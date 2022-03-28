package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.io.PipedReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

/** Interface linkInterface = new SubClass of Interface (1-Ошибка-Solved)*/
private final UserDao userDaoJdbc = new UserDaoJdbcImpl();
private  final User user = new User();




    public void createUsersTable() {
        userDaoJdbc.createUsersTable(user);

    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

       userDaoJdbc.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
       List<User> userList = userDaoJdbc.getAllUsers();

        return userList;
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}
