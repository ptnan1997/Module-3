package Session13.Bai2.ra.dao;

import Session13.Bai2.JDBC.database;
import Session13.Bai2.ra.entity.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements IStudent{

    @Override
    public List<Student> getAllStudents() {
        List< Student> students = new ArrayList<>();

       // Bước 1: Mở kết nối
        Connection conn = database.getConnection();

        // Bước 2: Tạo truy vấn bằng Callable
        try{

            CallableStatement callStmt = conn.prepareCall("{call get_all_students()}");
            // Bước 3: Thực thi truy vấn
            ResultSet rs = callStmt.executeQuery();
            // Bước 4: Xử lý dữ liệu trả về
            while(rs.next()){

                Student s = new Student(
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth"),
                        rs.getString("email")
                );
                s.setStudentId(rs.getInt("student_id"));
                students.add(s);
            }
            if (students.isEmpty()) {
                System.out.println("No students found");
            } else {
                for (Student s: students){
                    System.out.println(s);
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            database.closeConnection(conn);
        }
        return  students;
    }

    @Override
    public Student findById(int id) {
        // Bước 1: Mở kết nối
        Connection conn = database.getConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement callStmt = conn.prepareCall("{call find_student_by_ìd(?)}");
            callStmt.setInt(1, id);
            // Bước 3: Thực thi truy vấn
            ResultSet rs = callStmt.executeQuery();
            // Bước 4: Xử lý dữ liệu trả về
            if(rs.next()){
                Student s = new Student(
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth"),
                        rs.getString("email")
                );
                s.setStudentId(rs.getInt("student_id"));
                return s;
            }

        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            database.closeConnection(conn);
        }
        return  null;
    }

    @Override
    public void addStudent(Student student) {
        // Bước 1: Mở kết nối
        Connection conn = database.getConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement callStmt = conn.prepareCall("{call add_student(?,?,?)}");

            callStmt.setString(1, student.getFullName());
            callStmt.setString(2, student.getDateOfBirth().toString());
            callStmt.setString(3, student.getEmail());
            // Bước 3: Thực thi truy vấn
            callStmt.executeUpdate();
            System.out.println("Đã thêm thành công sinh viên✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            database.closeConnection(conn);
        }
    }

    @Override
    public void editStudent(Student student,int id_edit) {
        // Bước 1: Mở kết nối
        Connection conn = database.getConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement callStmt = conn.prepareCall("{call update_student(?,?,?,?)}");

            callStmt.setString(2, student.getFullName());
            callStmt.setString(3, student.getDateOfBirth().toString());
            callStmt.setString(4, student.getEmail());
            callStmt.setInt(1, id_edit);
            // Bước 3: Thực thi truy vấn
            callStmt.executeUpdate();
            System.out.println("Đã chỉnh sữa thành công thông tin sinh viên ✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            database.closeConnection(conn);
        }
    }

    @Override
    public void deleteStudentByID(Integer studentId) {
        // Bước 1: Mở kết nối
        Connection conn = database.getConnection();
        // Bước 2: Tạo truy vấn bằng Callable
        try{
            CallableStatement callStmt = conn.prepareCall("{call delete_student(?)}");
            callStmt.setInt(1, studentId);
            // Bước 3: Thực thi truy vấn
            callStmt.executeUpdate();
            System.out.println("Đã xóa thành công sinh viên ✅");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            database.closeConnection(conn);
        }
    }
}
