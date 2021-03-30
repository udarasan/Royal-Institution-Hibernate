package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.SuperBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.CourseDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean addCourse(CourseDTO course)throws Exception;
    public List<CourseDTO> getAllCourse()throws Exception;
    public boolean deleteCourse(String id)throws Exception;
    public boolean updateCourse(CourseDTO course)throws Exception;
}
