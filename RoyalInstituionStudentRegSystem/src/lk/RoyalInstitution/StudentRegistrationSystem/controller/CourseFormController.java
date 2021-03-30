package lk.RoyalInstitution.StudentRegistrationSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.BOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.CourseBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public class CourseFormController {
    public TextField txtCID;
    public TextField txtCourseName;
    public TextField txtCourseType;
    public TextField txtCourseDuration;
    public TableView tblCourse;
    public TableColumn colCID;
    public TableColumn colCName;
    public TableColumn colCType;
    public TableColumn colCDuration;
    CourseBO courseBO = BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);

    public void initialize() {
        colCID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colCName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCType.setCellValueFactory(new PropertyValueFactory<>("courseType"));
        colCDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        loadAllCourses();
    }

    private void loadAllCourses() {
        ObservableList<CourseDTO> items = tblCourse.getItems();
        items.clear();
        try {
            List<CourseDTO> allCourse = courseBO.getAllCourse();
            for (CourseDTO course : allCourse) {
                items.add(new CourseDTO(course.getCid(), course.getCourseName(),
                        course.getCourseType(), course.getDuration()));
            }
            tblCourse.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        String courseName = txtCourseName.getText();
        String courseType = txtCourseType.getText();
        String duration = txtCourseDuration.getText();

        CourseDTO courseDTO = new CourseDTO(cid, courseName, courseType, duration);
        try {
            boolean isAdded = courseBO.addCourse(courseDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Course Added Successful!", ButtonType.OK).show();
            loadAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Course Added Successful!", ButtonType.OK).show();

        }

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Meyawa Delete Karanna onamada..?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                courseBO.deleteCourse(cid);
                loadAllCourses();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        String courseName = txtCourseName.getText();
        String courseType = txtCourseType.getText();
        String duration = txtCourseDuration.getText();

        CourseDTO courseDTO = new CourseDTO(cid, courseName, courseType, duration);
        try {
            boolean isAdded = courseBO.updateCourse(courseDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Course Added Successful!", ButtonType.OK).show();
            loadAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Course Added Successful!", ButtonType.OK).show();

        }
    }

    public void rowSelectedEvent(MouseEvent mouseEvent) {
        CourseDTO courseDTO = (CourseDTO) tblCourse.getSelectionModel().getSelectedItem();
        txtCID.setText(courseDTO.getCid());
        txtCourseName.setText(courseDTO.getCourseName());
        txtCourseDuration.setText(courseDTO.getDuration());
        txtCourseType.setText(courseDTO.getCourseType());
    }
}
