package com.relink.chat.controller;

import com.relink.chat.ChatRoomApplication;
import com.relink.chat.component.Global;
import com.relink.chat.view.ChatRoomView;
import com.relink.chat.view.LoginView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LoginViewController implements Initializable {

    private Stage stage;

    @Autowired
    private LoginView loginView;

    @FXML
    private Button LoginBtn;

    @FXML
    private Button RegisterBtn;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private void LoginBtnClicked() {
        Global.username = username.getText();
        ChatRoomApplication.showView(ChatRoomView.class);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.textProperty().addListener((obs, oldVal, newVal) -> LoginBtn.setDisable(newVal.isEmpty()));
        init();
    }

    /**
     * 初始化界面
     */
    void init() {
        Platform.runLater(() -> {
            Parent parent = loginView.getView();
            LoginViewController.this.stage = (Stage) parent.getScene().getWindow();
            stage.setTitle("LoginView");
            stage.setResizable(false);
        });
    }
}
