package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.BOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.UserBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.UserDTO;

public class UserFormController {
    public TextField txtSignInUserName;
    public TextField txtSignInPassword;
    public TextField txtSignInConformPassword;
    public TextField txtUpdateUserName;
    public TextField txtUpdatePassword;
    public TextField txtUpdateConformPassword;
    public ImageView conformRight;
    public ImageView wrongID;

    UserBO userBO = BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    public void initialize() {
        conformRight.setVisible(false);
        wrongID.setVisible(false);
    }

    public void createAccountOnAction(ActionEvent actionEvent) {
        String signInUserName = txtSignInUserName.getText();
        String signInPassword = txtSignInPassword.getText();
        String conformISignInConformPassword=txtSignInConformPassword.getText();
        if (conformISignInConformPassword==signInPassword ) {
            conformRight.setVisible(true);
            wrongID.setVisible(true);
        }
        UserDTO userDTO = new UserDTO(signInUserName, signInPassword);
        try {
            boolean isAdded = userBO.addUser(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePasswordOnAction(ActionEvent actionEvent) {
        String userName = txtUpdateUserName.getText();
        String passWord = txtUpdatePassword.getText();
        UserDTO userDTO = new UserDTO(userName, passWord);
        try {
            boolean idAdded = userBO.updateUser(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountOnAction(ActionEvent actionEvent) {
        String userName = txtUpdateUserName.getText();
        String passWord = txtUpdatePassword.getText();
        UserDTO userDTO = new UserDTO(userName, passWord);
        try {
            boolean idAdded = userBO.deleteUser(userName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void conformPassword(MouseEvent inputMethodEvent) {

    }
}
