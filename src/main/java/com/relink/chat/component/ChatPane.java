package com.relink.chat.component;

import com.relink.chat.core.util.Translate;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * 文字框
 */
public class ChatPane extends AnchorPane {

    public ChatPane(String message, int state, String sender) {
        super.setPrefWidth(590);
        // 头像
        ImageView imageView = new ImageView(new Image("file:E:\\Github_repository\\springboot-javafx-activemq\\src\\main\\resources\\images\\image1.jpg"));
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        // 昵称
        Label label1 = new Label(sender);
        label1.setFont(new Font(13));
        if(state == Global.RIGHT) {
            label1.setTextAlignment(TextAlignment.RIGHT);
        }
        label1.setMaxWidth(400);
        // 消息
        Label label2 = new Label(message);
        label2.setFont(new Font(18));
        if(state == Global.RIGHT) {
            label2.setStyle("-fx-background-color: #56EE4B; -fx-background-radius: 5px");
        } else {
            label2.setStyle("-fx-background-color: #fff; -fx-background-radius: 5px");
        }

        label2.setPadding(new Insets(5,10,5,10));
        label2.setWrapText(true);
        label2.setMaxWidth(400);

        super.getChildren().addAll(imageView, label1, label2);
        // 定位
        if(state == Global.RIGHT) {
            AnchorPane.setLeftAnchor(imageView, 537.0);
            AnchorPane.setTopAnchor(imageView, 25.0);

            AnchorPane.setRightAnchor(label1, 70.0);
            AnchorPane.setTopAnchor(label1, 25.0);

            AnchorPane.setRightAnchor(label2, 70.0);
        } else {
            AnchorPane.setLeftAnchor(imageView, 22.0);
            AnchorPane.setTopAnchor(imageView, 25.0);

            AnchorPane.setLeftAnchor(label1, 70.0);
            AnchorPane.setTopAnchor(label1, 25.0);

            AnchorPane.setLeftAnchor(label2, 70.0);
        }
        AnchorPane.setTopAnchor(label2, 45.0);

        // 点击实现翻译
        label2.setOnMouseClicked(event -> {
            Dialog.showStandardDialog("中文翻译: " + Translate.toEnglish(message, "en", "zh") + "\n" +
                    "英文翻译: " + Translate.toEnglish(message, "zh", "en"));
        });
    }
}
