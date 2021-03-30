package lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.RegistrationBO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.DAOFactory;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.QueryDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.RegistrationDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dto.RegistrationDTO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Registration;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO= (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
    QueryDAO queryDAO= (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public boolean addRegistration(RegistrationDTO registration) throws Exception {
        Student id=queryDAO.getStudent(registration.getId());
        Course cid=queryDAO.getCourse(registration.getCid());
        return registrationDAO.add(new Registration(registration.getRid(),registration.getRegDate(),
                registration.getRegFee(),id,cid));
    }

    @Override
    public List<RegistrationDTO> getAllRegistration() throws Exception {
        List<Registration> studentsList = registrationDAO.getAll();

        List<RegistrationDTO> registrationDTOList = new ArrayList<>();

        for (Registration registration :studentsList ) {
            registrationDTOList.add(new RegistrationDTO(registration.getRid(),registration.getRegDate(),
                    registration.getRegFee(),registration.getStudent().getId(),registration.getCourse().getCid()));
        }
        return registrationDTOList;
    }

    @Override
    public boolean deleteRegistration(String id) throws Exception {
        return registrationDAO.delete(id);
    }

    @Override
    public boolean updateRegistration(RegistrationDTO registration) throws Exception {
        return false;
    }
}
