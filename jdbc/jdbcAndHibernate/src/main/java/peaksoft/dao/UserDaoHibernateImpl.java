package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.HibernateConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try{
            HibernateConfig.getSession();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("");

    }
/**      saveUser(User user)/ createUser?   */
    @Override
    public void saveUser(String name, String lastName, byte age) {

        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.save(new User(name,lastName,age));
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();


    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").getResultList();
        for (User u:users
             ) {
            System.out.println(u);
        }
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
