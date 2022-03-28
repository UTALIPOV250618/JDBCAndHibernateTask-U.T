package peaksoft.dao;

import org.hibernate.procedure.UnknownSqlResultSetMappingException;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.io.PipedReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private Util util;

    /** Model "User" is never used in this project*/
//    private final User user = new User();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
       String sql = "CREATE TABLE IF NOT EXISTS User1"+
               "(id SERIAL NOT NULL,"+
               "name varchar (50),"+
               "lastName varchar (50),"+
               "age INTEGER NOT NULL)";
       try(Connection connection = Util.connection();
           Statement statement = connection.createStatement()) {
           statement.executeUpdate(sql);
           System.out.println("Table created successfully");
       } catch (SQLException e){
           System.out.println(e.getMessage());
       }

    }

    @Override
    public void createUsersTable(User user) {

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE User1";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(sql);
            System.out.println("Table dropped successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT INTO User1(name,lastname,age) values(?,?,?)";
        try(Connection connection = Util.connection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("New user added successfully");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void removeUserById(long id) {
    String sql = "DELETE FROM User1 WHERE id=?;";
    try(Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
      String sql = "SELECT *FROM User1";
      try(Connection connection = Util.connection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql)){
          while (resultSet.next()){
              User user = new User();
             user.setId(resultSet.getLong("id"));
             user.setName(resultSet.getString("name"));
             user.setLastName(resultSet.getString("lastname"));
             user.setAge(resultSet.getByte("age"));
             users.add(user);
              System.out.println(user.toString());
          }
      }catch (SQLException e){
          System.out.println(e.getMessage());
      }

        return users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE User1";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


}