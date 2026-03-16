package Session13.Bai8.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_bai8 {
    private static final String url = "jdbc:mysql://localhost:3306/java_connector";
    private static final String user = "root";
    private static final String password = "123456";

    public static Connection openConnection(){
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException e ){
            throw new  RuntimeException(e);
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if (conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
