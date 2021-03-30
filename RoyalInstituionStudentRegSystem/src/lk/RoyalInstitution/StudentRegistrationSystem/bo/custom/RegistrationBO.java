package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.SuperBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.CourseDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    public boolean addRegistration(RegistrationDTO registration)throws Exception;
    public List<RegistrationDTO> getAllRegistration()throws Exception;
    public boolean deleteRegistration(String id)throws Exception;
    public boolean updateRegistration(RegistrationDTO registration)throws Exception;
}
