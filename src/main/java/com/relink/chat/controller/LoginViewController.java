package com.relink.chat.controller;

import com.relink.chat.ChatRoomApplication;
import com.relink.chat.component.Dialog;
import com.relink.chat.component.Global;
import com.relink.chat.core.util.ReturnNo;
import com.relink.chat.core.util.ReturnObject;
import com.relink.chat.dao.UserDao;
import com.relink.chat.view.ChatRoomView;
import com.relink.chat.view.LoginView;
import com.relink.chat.view.RegisterView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@Component
public class LoginViewController implements Initializable {

    private Stage stage;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginView loginView;

    @FXML
    private Button jumpToChat;

    @FXML
    private Button jumpToRegister;

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private void LoginBtnClicked() {
        ReturnObject ret =  userDao.login(loginUsername.getText(), loginPassword.getText());
        if(ret.getCode() == ReturnNo.OK) {
            Global.username = loginUsername.getText();
            ChatRoomApplication.showView(ChatRoomView.class);
        } else {
            Dialog.showErrorDialog(ret.getCode().getMessage());
        }
    }

    @FXML
    private void RegisterBtnClicked() {
        ChatRoomApplication.showView(RegisterView.class);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
