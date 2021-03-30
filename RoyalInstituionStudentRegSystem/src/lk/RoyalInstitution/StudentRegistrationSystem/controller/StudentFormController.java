package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.BOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.StudentBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class StudentFormController {
    public TextField txtStudentID;
    public TextField txtStudentName;
    public TextField txtStudentAddress;
    public TextField txtStudentContact;
    public DatePicker pickDate;
    public TextField txtStudentGender;
    public TableView tblStudent;
    public TableColumn colSID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContacts;
    public TableColumn colDOB;
    public TableColumn colGender;

    StudentBO studentBO=BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize(){
        colSID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContacts.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        loadAllStudents();
    }

    private void loadAllStudents() {
        ObservableList<StudentDTO>items=tblStudent.getItems();
        items.clear();
        try {
            List<StudentDTO>allStudent=studentBO.getAllStudents();
            for (StudentDTO student : allStudent){
                items.add(new StudentDTO(student.getId(),student.getName(),student.getAddress()
                        ,student.getContact(),student.getDob(),student.getGender()));
            }
            tblStudent.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtStudentAddress.getText();
        String contact=txtStudentContact.getText();
        String dob=pickDate.getValue().toString();
        String gender=txtStudentGender.getText();

        StudentDTO studentDTO=new StudentDTO(id,name,address,contact,dob,gender);
        try {
            boolean isAdded= studentBO.addStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !",ButtonType.OK).show();
            loadAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }

    }


    public void deleteOnAction(ActionEvent actionEvent) {
        String id=txtStudentID.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Meyawa Delete Karanna onamada..?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                studentBO.deleteStudent(id);
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!", ButtonType.OK).show();

            }
            loadAllStudents();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Not Deleted!",ButtonType.OK).show();
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtStudentAddress.getText();
        String contact=txtStudentContact.getText();
        String dob=pickDate.getValue().toString();
        String gender=txtStudentGender.getText();

        StudentDTO studentDTO=new StudentDTO(id,name,address,contact,dob,gender);
        try {
            boolean isAdded= studentBO.updateStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !",ButtonType.OK).show();
            loadAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }

    }

    public void rowSelectOnAction(MouseEvent mouseEvent) {
        StudentDTO studentDTO = (StudentDTO) tblStudent.getSelectionModel().getSelectedItem();
        txtStudentID.setText(studentDTO.getId());
        txtStudentName.setText(studentDTO.getName());
        txtStudentContact.setText(studentDTO.getContact());
        pickDate.setValue(LocalDate.parse(studentDTO.getDob()));
        txtStudentAddress.setText(studentDTO.getAddress());
        txtStudentGender.setText(studentDTO.getGender());
    }
}
