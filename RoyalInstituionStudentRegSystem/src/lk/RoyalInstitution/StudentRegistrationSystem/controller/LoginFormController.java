package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.BOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.UserBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.UserDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.UserDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.User;

import java.io.IOException;
import java.util.List;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
    public PasswordField pwdPassword;
    public AnchorPane loginPane;
    /*String userName=txtUserName.getText();
    String password=txtPassword.getText();*/

    UserBO userBO= BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    public void initialize(){
        txtPassword.setVisible(false);
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        loginPane.getChildren().clear();
        Stage window = (Stage) this.loginPane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass()
                .getResource("../view/DashBordForm.fxml"))));
        window.centerOnScreen();

    }

    public void eyeClickAction(MouseEvent mouseEvent) {
        txtPassword.setText(pwdPassword.getText());
        pwdPassword.setVisible(false);
        txtPassword.setVisible(true);

    }

    public void eyeClickExitAction(MouseEvent mouseEvent) {
        pwdPassword.setVisible(true);
        txtPassword.setVisible(false);
    }

    public void signupOnAction(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage) this.loginPane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass()
                .getResource("../view/UserForm.fxml"))));
        window.centerOnScreen();


    }
}
