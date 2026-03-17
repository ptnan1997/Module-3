package Bai2.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_bai2 {
    private static final String url = "jdbc:mysql://localhost:3306/Session14";
    private static final String user = "root";
    private static final String password = "123456";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection  openConnection(){
        Connection con;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if (con != null){
                System.out.println("Connected to database.");
            } else {
                System.out.println("Failed to initialize the database connection.");
            }
        } catch (SQLException | ClassNotFoundException e ){
            throw new RuntimeException();
        }
        return con;
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
