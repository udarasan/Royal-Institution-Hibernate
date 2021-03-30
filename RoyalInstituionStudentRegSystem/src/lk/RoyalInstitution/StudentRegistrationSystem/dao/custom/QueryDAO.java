package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.SuperDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;

public interface QueryDAO extends SuperDAO {
    public Student getStudent(String id)throws Exception;
    public Course getCourse(String code)throws Exception;
}
