package lk.RoyalInstitution.StudentRegistrationSystem.bo;

import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl.CourseBOImpl;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl.RegistrationBOImpl;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl.StudentBOImpl;
import lk.RoyalInstitution.StudentRegistrationSystem.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;


    private BOFactory() {

    }

    public enum BOType {
        STUDENT,COURSE,REGISTRATION,USER
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case USER:
                return (T) new UserBOImpl();
            default:
                return null;
        }
    }
}
