package lk.RoyalInstitution.StudentRegistrationSystem.utill;

import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Registration;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Registration.class)
                .addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
