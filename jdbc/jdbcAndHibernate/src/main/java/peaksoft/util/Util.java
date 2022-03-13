package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String url ="jdbc:postgresql://localhost:5432/postgres";
    public static final String userName ="postgres";
    public static final String password ="google224";


    public  static Connection connection(){
        Connection connection = null;
        try {
           connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Successfully connected to DB");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
