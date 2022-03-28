package com.relink.chat;

import com.relink.chat.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 */

@MapperScan("com.relink.chat.mapper")
@SpringBootApplication
public class ChatRoomApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(ChatRoomApplication.class, LoginView.class, new CustomSplashScreen(), args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
}
