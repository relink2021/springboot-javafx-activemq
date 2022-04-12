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

/**
 * 文件框
 */
public class FilePane extends AnchorPane {

    public FilePane(String message, byte[] buf, int state, String sender, Stage stage) {
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
        // 文件
        BorderPane file_content = new BorderPane();
        BorderPane rightPane = new BorderPane();
        String type = message.substring(message.lastIndexOf('.') + 1);

        /**
         * 22/4/26 彭灏改动，读入文件图标图片
         * */
        //start
        String simpleend="."+type;
        File f=null;
        try {
            f = File.createTempFile("icon", simpleend);

        }catch (Exception e)
        {

        }

        Icon fileicon=FileType.getSmallIcon(f);
        BufferedImage bufferedImage = new BufferedImage(
                fileicon.getIconWidth(),
                fileicon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB
        );
        fileicon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
        Image fxImage= SwingFXUtils.toFXImage(bufferedImage,null);
        f.deleteOnExit();
        //end
//  以下未改动
        ImageView icon = new ImageView(fxImage);
        icon.setFitWidth(55.0);
        icon.setFitHeight(60.0);
        // 文件名
        double byte_len = buf.length;
        int cnt = 0;
        while(byte_len > 1024) {
            byte_len = byte_len / 1024.0;
            cnt++;
        }
        // 计算文件大小
        Label filename = new Label(message + String.format("(%.1f%s)", byte_len, FileSize.getValue(cnt)));
        filename.setFont(new Font(18));
        // 下载按钮
        DownLoadButton download = new DownLoadButton(stage, "点击下载", buf, message);
        download.setTextFill(Paint.valueOf("#7777e7"));
        download.setStyle("-fx-background-color: #fff; -fx-border-color: #fff; -fx-font-size: 18;");
        // 装入右框架
        rightPane.setTop(filename);
        rightPane.setBottom(download);
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
