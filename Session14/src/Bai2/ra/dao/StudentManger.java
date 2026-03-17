package Bai2.ra.dao;

import Bai1.JDBC.database01;
import Bai2.ra.entity.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentManger {
    // Yêu cầu bài 2
    public void updateStudent(int studentId, Student student ){
        // Mở kết nối
        try(Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call =  con.prepareCall("{call update_student(?,?,?)}");
            call.setInt(1, studentId);
            call.setString(2, student.getStudentName());
            call.setInt(3, student.getAge());
            int up = call.executeUpdate();
            if (up == 0){
                con.rollback();
            }
            con.commit();
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
    // Yêu cầu bài 3
    public void deleteStudenByAge (int age){
        // Mở kết nối
        try(Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call =   con.prepareCall("{call delete_student_by_age(?)}");
            call.setInt(1, age);
            int up = call.executeUpdate();
            if (up == 0){
                con.rollback();
            }
            con.commit();
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
