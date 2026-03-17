package Bai3;

import Bai2.ra.dao.StudentManger;

public class Main03 {
    public static void main(String[] args) {
        StudentManger studentManager  = new StudentManger();

        studentManager.deleteStudenByAge(3);

    }
}
