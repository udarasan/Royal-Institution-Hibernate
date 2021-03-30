package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.BOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.RegistrationBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.RegistrationDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Registration;

import java.util.List;


public class RegistrationFormController {
    public TableColumn colRID;
    public TableColumn colDate;
    public TableColumn colStudentFee;
    public TableColumn colStudentID;
    public TableColumn colCourseID;

    RegistrationBO registrationbo = BOFactory.getInstance().getBO(BOFactory.BOType.REGISTRATION);

    public TextField txtRegID;
    public TextField txtStudentFee;
    public TextField txtStudentId;
    public TextField txtCourseId;
    public DatePicker txtRegDate;
    public TableView tblRegistration;


    public void initialize() {

        colRID.setCellValueFactory(new PropertyValueFactory<>("rid"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        colStudentFee.setCellValueFactory(new PropertyValueFactory<>("regFee"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("cid"));

        loadAllRegistrations();
    }

    private void loadAllRegistrations() {
        ObservableList<RegistrationDTO>items=tblRegistration.getItems();
        items.clear();
        List<RegistrationDTO>allRegistrations= null;
        try {
            allRegistrations = registrationbo.getAllRegistration();
            for (RegistrationDTO registration : allRegistrations){
                items.add(new RegistrationDTO(registration.getRid(),registration.getRegDate()
                        ,registration.getRegFee(),registration.getId(),registration.getCid()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveOnAction(ActionEvent actionEvent) {
        int rid = 0;
        String regDate = txtRegDate.getValue().toString();
        double studentFee = Double.parseDouble(txtStudentFee.getText());
        String id = txtStudentId.getText();
        String cid = txtCourseId.getText();

        RegistrationDTO registrationDTO = new RegistrationDTO(rid, regDate, studentFee, id, cid);
        try {
            boolean isAdded = registrationbo.addRegistration(registrationDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successful !", ButtonType.OK).show();
            loadAllRegistrations();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }


    }
}
