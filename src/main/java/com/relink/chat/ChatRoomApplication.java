package com.relink.chat;

import com.relink.chat.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;

/**
 * 启动类
 * 开启定时功能
 */

@MapperScan("com.relink.chat.mapper")
@SpringBootApplication
@EnableScheduling
public class ChatRoomApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(ChatRoomApplication.class, LoginView.class, new CustomSplashScreen(), args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> topicListenerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setClientId("A");
        return factory;
    }
}
