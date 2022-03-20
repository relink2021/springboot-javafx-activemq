package com.relink.chat.component;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 下载按钮
 */
public class DownLoadButton extends Button {

    private final byte[] bytes;

    public DownLoadButton(Stage stage, String name, byte[] bytes, String fileName) {
        super(name);
        this.bytes = bytes;
        super.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Download");
            fileChooser.setInitialFileName(fileName);
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("ALL", "*.*")
            );
            File file = fileChooser.showSaveDialog(stage);
            try {
                if(file != null) {
                    FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
                    out.write(this.bytes);
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
