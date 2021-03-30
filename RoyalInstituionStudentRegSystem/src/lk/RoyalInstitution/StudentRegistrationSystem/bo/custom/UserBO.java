package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.SuperBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.StudentDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    public boolean addUser(UserDTO user)throws Exception;
    public List<UserDTO> getAllUsers()throws Exception;
    public boolean deleteUser(String userName)throws Exception;
    public boolean updateUser(UserDTO user)throws Exception;
}
