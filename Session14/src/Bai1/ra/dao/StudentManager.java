package Bai1.ra.dao;

import Bai1.JDBC.database01;
import Bai1.ra.entity.Students;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;



public class StudentManager implements IManager{

    @Override
    public void addStudents(Students student) throws SQLException {
        // Mở kết nối
        Connection con = database01.openConnection();
        try {

            con.setAutoCommit(false);

            CallableStatement call = con.prepareCall("{call add_student(?,?) }");
            call.setString(1, student.getStudentName());
            call.setInt(2, student.getAge());
            call.executeUpdate();
            call.close();
            con.commit();
            System.out.println("Added student successfully");
        }catch (SQLException e){
            con.rollback();
            System.out.println(e.getMessage());
        }
    }
}
