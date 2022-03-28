package com.relink.chat.controller;

import com.relink.chat.ChatRoomApplication;
import com.relink.chat.component.Dialog;
import com.relink.chat.core.util.ReturnNo;
import com.relink.chat.core.util.ReturnObject;
import com.relink.chat.dao.UserDao;
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
public class RegisterViewController implements Initializable {

    private Stage stage;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RegisterView registerView;

    @FXML
    private TextField registerUsername;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private PasswordField checkPassword;

    @FXML
    private Button jumpToLogin;

    @FXML
    private Button registerBtn;

    @FXML
    private void LoginBtnClicked() {
        ChatRoomApplication.showView(LoginView.class);
    }

    @FXML
    private void RegisterBtnClicked() {
        ReturnObject ret = userDao.register(registerUsername.getText(), registerPassword.getText(), checkPassword.getText());
        if(ret.getCode() == ReturnNo.OK) {
            Dialog.showStandardDialog("注册成功");
        } else {
            Dialog.showErrorDialog(ret.getCode().getMessage());
        }
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
            Parent parent = registerView.getView();
            RegisterViewController.this.stage = (Stage) parent.getScene().getWindow();
            stage.setTitle("RegisterView");
            stage.setResizable(false);
        });
    }
}
