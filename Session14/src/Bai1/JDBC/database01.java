package Bai1.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database01 {
    private static final String url = "jdbc:mysql://localhost:3306/session14";
    private static final String user = "root";
    private static final String password = "123456";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection openConnection(){
        Connection  conn ;
        try{
            Class.forName(driver);
            // Mở kết nối
             conn  = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("Connected to database.");
            } else {
                System.out.println("Failed to initialize the database connection.");
            }
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new  RuntimeException(e);
            }
        }
    }
}
