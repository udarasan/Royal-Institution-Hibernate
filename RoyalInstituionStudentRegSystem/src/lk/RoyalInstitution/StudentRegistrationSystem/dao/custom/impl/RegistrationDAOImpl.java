package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.RegistrationDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Registration;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;
import lk.RoyalInstitution.StudentRegistrationSystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean add(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
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

        session.createNativeQuery("delete from Registration where rid='"+id+"'", Registration.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();


        List<Registration> list = session.createNativeQuery("SELECT * FROM Registration",Registration.class).list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Registration search(Registration entity) throws Exception {
        return null;
    }
}
