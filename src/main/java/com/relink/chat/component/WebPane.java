package com.relink.chat.component;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.Icon;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.SyncFailedException;


public class WebPane extends AnchorPane {
    private ImageView icon;

    public WebPane(String message, int state, String sender, Stage stage)
    {
// 头像
        ImageView imageView = new ImageView(new Image("https://img2.baidu.com/it/u=2453667744,808227769&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        // 昵称
        Label label1 = new Label(sender);
        label1.setFont(new Font(13));
        if(state == Global.RIGHT) {
            label1.setTextAlignment(TextAlignment.RIGHT);
        }
        label1.setMaxWidth(400);
        BorderPane file_content = new BorderPane();
        BorderPane rightPane = new BorderPane();
        this.icon=new ImageView(new Image("https://img2.baidu.com/it/u=2453667744,808227769&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        icon.setFitHeight(40);
        icon.setFitWidth(40);
        WebAccessButton access = new WebAccessButton("点击访问",stage,message);
        access.setTextFill(Paint.valueOf("#7777e7"));
        access.setStyle("-fx-background-color: #fff; -fx-border-color: #fff; -fx-font-size: 18;");
        // 装入右框架
        Label mes2=new Label(message);
        rightPane.setTop(mes2);
        rightPane.setBottom(access);
        // 装入主框架
        file_content.setLeft(icon);
        file_content.setRight(rightPane);
        file_content.setPadding(new Insets(5,5,5,5));
        file_content.setStyle("-fx-background-color: #fff; -fx-border-radius: 2px; -fx-border-color: #bebeff");
        super.getChildren().addAll(imageView, label1, file_content);
        // 定位
        if(state == Global.RIGHT) {
            AnchorPane.setLeftAnchor(imageView, 537.0);
            AnchorPane.setTopAnchor(imageView, 25.0);

            AnchorPane.setRightAnchor(label1, 70.0);
            AnchorPane.setTopAnchor(label1, 25.0);

            AnchorPane.setRightAnchor(file_content, 70.0);
        } else {
            AnchorPane.setLeftAnchor(imageView, 22.0);
            AnchorPane.setTopAnchor(imageView, 25.0);

            AnchorPane.setLeftAnchor(label1, 70.0);
            AnchorPane.setTopAnchor(label1, 25.0);

            AnchorPane.setLeftAnchor(file_content, 70.0);
        }
        AnchorPane.setTopAnchor(file_content, 45.0);

    }
}
