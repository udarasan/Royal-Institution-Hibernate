package lk.RoyalInstitution.StudentRegistrationSystem.dao;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        STUDENT,COURSE,REGISTRATION,QUERY,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case STUDENT:
                return new StudentDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case  REGISTRATION:
                return new RegistrationDAOImpl();
            case  QUERY:
                return new QueryDAOImpl();
            case  USER:
                return new UserDAOImpl()

                            ;

            default:
                return null;
        }
    }
}
