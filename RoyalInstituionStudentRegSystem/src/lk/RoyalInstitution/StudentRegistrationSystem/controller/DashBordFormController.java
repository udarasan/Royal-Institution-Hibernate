package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashBordFormController {

    public Pane root;

    public void initialize() throws IOException {
        setUi("RegistrationForm");
    }

    public void studentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StudentForm");
    }

    private void setUi(String location) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.
                load(this.getClass().
                        getResource("../view/" + location +
                                ".fxml")));
    }

    public void courseOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseForm");
    }

    public void registrationFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RegistrationForm");
    }

    public void onClickAccountAction(MouseEvent mouseEvent) throws IOException {
        setUi("UserForm");
    }

}
