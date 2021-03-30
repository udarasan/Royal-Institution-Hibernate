package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.SuperBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean addStudent(StudentDTO student)throws Exception;
    public List<StudentDTO> getAllStudents()throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public boolean updateStudent(StudentDTO student)throws Exception;
}
