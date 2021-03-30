package lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.impl;
import lk.RoyalInstitution.StudentRegistrationSystem.dao.custom.CourseDAO;
import lk.RoyalInstitution.StudentRegistrationSystem.entity.Course;
import lk.RoyalInstitution.StudentRegistrationSystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean add(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
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

        session.createNativeQuery("delete from Course where cid='"+id+"'",Course.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();


        List<Course> list = session.createNativeQuery("SELECT * FROM course",Course.class).list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Course search(Course entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            session.beginTransaction();
            Course course=session.find(Course.class, entity.getCid());
            session.getTransaction().commit();
            return course;
        }catch (Exception exception){

        }

        return null;

    }

}
