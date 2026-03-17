package Bai2;

import Bai2.ra.dao.StudentManger;
import Bai2.ra.entity.Student;

public class Main02 {
    public static void main(String[] args) {
        StudentManger studentManger = new StudentManger();

        studentManger.updateStudent(2,new Student("Nguyễn Hào",30));
        System.out.println("Cập nhật thành công sinh ✅");
    }
}
