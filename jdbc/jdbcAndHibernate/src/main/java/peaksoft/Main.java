package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDaoJdbcImpl users = new UserDaoJdbcImpl();
        UserDaoJdbcImpl user1  =new UserDaoJdbcImpl();
        UserDaoJdbcImpl user2  =new UserDaoJdbcImpl();
        UserDaoJdbcImpl user3  =new UserDaoJdbcImpl();
        UserDaoJdbcImpl user4  =new UserDaoJdbcImpl();

        users.createUsersTable();

        user1.saveUser("Ulukmyrza","Talipov", (byte) 30);
        user2.saveUser("Muna","Talipova", (byte) 28);
        user3.saveUser("Sulaiman","Ulukmyrzaev", (byte) 4);
        user4.saveUser("Dati","Talipova", (byte) 28);
        users.getAllUsers();
//        users.cleanUsersTable();
//          users.dropUsersTable();











    }
}
