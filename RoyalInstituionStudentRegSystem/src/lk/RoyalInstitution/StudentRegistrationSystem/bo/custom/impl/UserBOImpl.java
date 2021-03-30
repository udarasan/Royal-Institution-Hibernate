package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.UserBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.DAOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.UserDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.UserDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO= (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean addUser(UserDTO user) throws Exception {
        return userDAO.add(new User(user.getUserName(),user.getPassword()));
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<User> userList = userDAO.getAll();

        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user :userList ) {
            userDTOList.add(new UserDTO(user.getUserName(),user.getPassword()));
        }
        return userDTOList;
    }

    @Override
    public boolean deleteUser(String userName) throws Exception {
        return userDAO.delete(userName);
    }

    @Override
    public boolean updateUser(UserDTO user) throws Exception {
        return userDAO.update(new User(user.getUserName(), user.getPassword()));

    }
}
