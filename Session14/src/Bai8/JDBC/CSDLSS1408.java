package Bai8.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CSDLSS1408 {
    private static final String url = "jdbc:mysql://localhost:3306/session14_bai8";
    private static final String user = "root";
    private static final String password = "123456";

    public Connection getConnection() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            if (con != null){
                System.out.println("Connected to database.");
            } else {
                System.out.println("Failed to initialize the database connection.");
            }

        } catch  (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }
        return con;
    }

}
