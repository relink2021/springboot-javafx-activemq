package com.relink.chat.controller;

import com.relink.chat.component.ChatPane;
import com.relink.chat.component.FilePane;
import com.relink.chat.component.Global;
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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class ChatRoomViewController implements Initializable {

    private Stage stage;

    private ChatPane chatPane;

    private FilePane filePane;

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
    private void sendTextMessage() {
        jmsTemplate.send("topic01", session -> {
            chatPane = new ChatPane(chatMessage.getText(), Global.RIGHT, Global.username);
            messageVbox.getChildren().add(chatPane);
            TextMessage textMessage = session.createTextMessage(chatMessage.getText());
            textMessage.setJMSCorrelationID(Global.username);
            chatMessage.clear();
            messageScrollPane.setVvalue(1.0);
            return textMessage;
        });
    }

    /**
     * 发送文件
     */
    @FXML
    private void sendFileMessage() throws Exception {
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
     * 接收方
     */
    @JmsListener(destination = "topic01")
    private void receiveMessage(Message message) throws JMSException {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String sender = textMessage.getJMSCorrelationID();
            if(!sender.equals(Global.username)) {
                chatPane = new ChatPane(textMessage.getText(), Global.LEFT, sender);
                Platform.runLater(() -> {
                    messageVbox.getChildren().add(chatPane);
                    messageScrollPane.setVvalue(1.0);
                });
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        nameLabel.setText(Global.username);
        chatMessage.textProperty().addListener((obs, oldVal, newVal) -> sendMessageBtn.setDisable(newVal.isEmpty()));
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
}
