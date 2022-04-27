package com.relink.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.relink.chat.component.ChatPane;
import com.relink.chat.component.FilePane;
import com.relink.chat.component.Global;
import com.relink.chat.component.LinkPane;
import com.relink.chat.core.util.Translate;
import com.relink.chat.component.WebPane;
import com.relink.chat.core.util.WebBrowser;
import com.relink.chat.view.ChatRoomView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@Configuration
@EnableJms
public class ChatRoomViewController implements Initializable {

    private Stage stage;

    private ChatPane chatPane;

    private FilePane filePane;

    private LinkPane linkPane;

    private WebPane webPane;

    private WebBrowser webBrowser;

    private final String timingMsg = "尚未打卡的同学，抓紧登录“Daily Health Report 健康打卡”系统 http://xmuxg.xmu.edu.cn/xmu/app/214 打卡";

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ChatRoomView chatRoomView;

    @FXML
    private Label nameLabel;

    @FXML
    private VBox messageVbox;

    @FXML
    private TextArea chatMessage;

    @FXML
    private Button sendMessageBtn;

    @FXML
    private Button sendFileBtn;


    @FXML
    private ScrollPane messageScrollPane;

    /**
     * 发送文本
     */
    @FXML
    public void sendTextMessage() {
        commonSendText();
    }

    /**
     * 发送文件
     */
    @FXML
    public void sendFileMessage() throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("FileChooser");
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            jmsTemplate.send("topic01", session ->  {
                filePane = new FilePane(file.getName(), bytes, Global.RIGHT, Global.username, stage);
                messageVbox.getChildren().add(filePane);
                StreamMessage streamMessage = session.createStreamMessage();
                streamMessage.writeInt((int) file.length());
                streamMessage.writeBytes(bytes);
                streamMessage.writeString(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
                streamMessage.setJMSCorrelationID(Global.username);
                return streamMessage;
            });
        }
    }

    /**
     * 定时发送消息: 定时提醒打卡机器人
     * 测试时: fixedDelay 10秒发送一次
     * 实际应用: cron 每隔30分钟发送一次
     * 根据测试需要自行调整
     */
      @Scheduled(cron = "0 */30 * * * ?")
//    @Scheduled(fixedDelay = 10000)
    public void sendTimingMessage() {
        Platform.runLater(() -> {
            jmsTemplate.send("topic01", session -> {
                TextMessage textMessage = session.createTextMessage(timingMsg);
                textMessage.setJMSCorrelationID("自动打卡机器人");
                return textMessage;
            });
        });
    }

    /**
     * 接收方
     */
    @JmsListener(destination = "topic01")
    private void receiveMessage(Message message, Session session) {
        try {

            if(message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String sender = textMessage.getJMSCorrelationID();
                if(!sender.equals(Global.username)) {
                    if(sender.equals("自动打卡机器人")) {
                        linkPane = new LinkPane(textMessage.getText(), Global.LEFT, sender);
                        Platform.runLater(() -> {
                            if(messageVbox == null) {
                                return;
                            }
                            messageVbox.getChildren().add(linkPane);
                            messageScrollPane.setVvalue(1.0);
                        });
                    }
                    /**
                     * 22/04/27彭灏改动，加入网页修改
                     */
                    else if(webBrowser.webstart(textMessage.getText())==1){
                        webPane = new WebPane(textMessage.getText(), Global.LEFT, sender,stage);
                        Platform.runLater(() -> {
                            messageVbox.getChildren().add(webPane);
                            messageScrollPane.setVvalue(1.0);
                        });
                    }

                    else {
                        chatPane = new ChatPane(textMessage.getText(), Global.LEFT, sender);
                        Platform.runLater(() -> {
                            messageVbox.getChildren().add(chatPane);
                            messageScrollPane.setVvalue(1.0);
                        });
                    }
                }
            } else if (message instanceof StreamMessage) {
                StreamMessage streamMessage = (StreamMessage) message;
                String sender = streamMessage.getJMSCorrelationID();
                if(!sender.equals(Global.username)) {
                    int file_len = streamMessage.readInt();
                    byte[] buf = new byte[file_len];
                    streamMessage.readBytes(buf);
                    String filename = streamMessage.readString();
                    FilePane filePane = new FilePane(filename, buf, Global.LEFT, sender, stage);
                    Platform.runLater(() -> {
                        messageVbox.getChildren().add(filePane);
                        messageScrollPane.setVvalue(1.0);
                    });
                }
            }
            session.commit();
        } catch (JMSException e) {
            try {
                session.rollback();
            } catch (JMSException e1) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        nameLabel.setText(Global.username);
        chatMessage.textProperty().addListener((obs, oldVal, newVal) -> sendMessageBtn.setDisable(newVal.isEmpty()));
        chatMessage.setOnKeyPressed(event -> {
            if(event.isAltDown() && event.getCode() == KeyCode.S && !chatMessage.getText().isEmpty()) {
                commonSendText();
            }
        });
    }

    /**
     * 初始化界面
     */
    void init() {
        Platform.runLater(() -> {
            Parent parent = chatRoomView.getView();
            ChatRoomViewController.this.stage = (Stage) parent.getScene().getWindow();
            stage.setTitle("ChatRoomView");
            stage.setResizable(false);
        });
    }

    /**
     * 发送消息的动作
     */
    private void commonSendText() {

        if(webBrowser.webstart(chatMessage.getText())==0)
        {jmsTemplate.send("topic01", session -> {



            chatPane = new ChatPane(chatMessage.getText(), Global.RIGHT, Global.username);
            messageVbox.getChildren().add(chatPane);
            TextMessage textMessage = session.createTextMessage(chatMessage.getText());
            textMessage.setJMSCorrelationID(Global.username);
            chatMessage.clear();
            messageScrollPane.setVvalue(1.0);
            return textMessage;


        }
        );}
        else
        {
               jmsTemplate.send("topic01", session ->  {
                  WebPane  webPane= new WebPane(chatMessage.getText(),Global.RIGHT,Global.username, stage);
                  messageVbox.getChildren().add(webPane);
                   TextMessage textMessage = session.createTextMessage(chatMessage.getText());
                   textMessage.setJMSCorrelationID(Global.username);
                   chatMessage.clear();
                   return textMessage;

               });
        }

    }
}
