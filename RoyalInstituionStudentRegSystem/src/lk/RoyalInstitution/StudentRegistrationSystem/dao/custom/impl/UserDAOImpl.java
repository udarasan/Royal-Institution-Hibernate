package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl;

import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.UserDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Student;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.User;
import lk.RoyalInstitution.StudentRegistrationSystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(String userName) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from User where userName='"+userName+"'", User.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();


        List<User> list = session.createNativeQuery("SELECT * FROM User",User.class).list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public User search(User entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            session.beginTransaction();
            User user=session.find(User.class, entity.getUserName());
            session.getTransaction().commit();
            return user;
        }catch (Exception exception){

        }
        return null;
    }

}
