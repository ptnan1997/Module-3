package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String url = "jdbc:mysql://localhost:3306/session15";
    private static final String user = "root";
    private static final String password = "123456";

    public static Connection openConnection(){
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            if (conn != null){
                return conn;
            } else {
                System.out.println("Unable to connect to the database");
            }
        } catch (SQLException | ClassNotFoundException e){
            throw new  RuntimeException(e);
        }
        return conn;
    }
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new  RuntimeException(e);
            }
        }
    }
}
