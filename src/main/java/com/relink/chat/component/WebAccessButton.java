package com.relink.chat.component;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebAccessButton  extends Button{

    public  WebAccessButton(String name,Stage stage,String webpath)
    {
        super(name);
        super.setOnAction(event -> {
            try {

                Desktop.getDesktop().browse(new URI(webpath));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

}
