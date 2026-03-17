package Bai1.presentation;

import Bai1.ra.dao.StudentManager;
import Bai1.ra.entity.Students;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main01 {
    public static void main(String[] args) throws SQLException {

        StudentManager studentManager = new StudentManager();

        Students student1  = new Students("Nguyễn Văn A",22);
        studentManager.addStudents(student1);
    }
}
