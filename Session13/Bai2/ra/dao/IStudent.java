package Session13.Bai2.ra.dao;

import Session13.Bai2.ra.entity.Student;

import java.util.List;

public interface IStudent {
    List<Student> getAllStudents();
    Student findById(int id);
    void addStudent(Student student);
    void editStudent (Student student,int editId);
    void deleteStudentByID (Integer studentId);
}
