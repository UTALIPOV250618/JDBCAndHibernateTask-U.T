package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.HibernateConfig;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable(User user) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Table created successfully");
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
        Query query = session.createQuery("DELETE FROM User");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
