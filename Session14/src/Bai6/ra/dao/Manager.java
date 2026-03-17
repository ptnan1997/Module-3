package Bai6.ra.dao;

import Bai1.JDBC.database01;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Manager {
    public void assignEmployeeToProject(int employId,int project){
        // Mở kết nối
        try(Connection con = database01.openConnection()){
            // setAutoCommit = false
            con.setAutoCommit(false);
            // Gọi thủ tục
            CallableStatement call = con.prepareCall("{call assign_employee_to_project(?,?)}");
            call.setInt(1, project);
            call.setInt(2, employId);
            int  i = call.executeUpdate();
            if(i == 0){
                System.out.println("No employee assigned to project");
                con.rollback();
            }
            con.commit();
        } catch (SQLException e){
            System.out.println("Error in assigning employee to project");
        }
    }
}
