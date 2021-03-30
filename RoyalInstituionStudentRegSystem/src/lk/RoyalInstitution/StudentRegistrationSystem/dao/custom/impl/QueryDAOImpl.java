package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.SuperDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.QueryDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;
import lk.RoyalInstitution.StudentRegistrationSystem.utill.FactoryConfiguration;
import org.hibernate.Session;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public Student getStudent(String id) throws Exception {

            Session session = FactoryConfiguration.getInstance().getSession();
            session.beginTransaction();
            Student student=session.find(Student.class,id);
            session.getTransaction().commit();
            return student;

    }

    @Override
    public Course getCourse(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.beginTransaction();
        Course course=session.find(Course.class,id);
        session.getTransaction().commit();
        return course;
    }
}
