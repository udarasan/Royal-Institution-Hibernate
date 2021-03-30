package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.StudentDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;
import lk.RoyalInstitution.StudentRegistrationSystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from Student where id='"+id+"'",Student.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();


        List<Student> list = session.createNativeQuery("SELECT * FROM student",Student.class).list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Student search(Student entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            session.beginTransaction();
            Student student=session.find(Student.class, entity.getId());
            session.getTransaction().commit();
            return student;
        }catch (Exception exception){

        }
        return null;
    }

}
