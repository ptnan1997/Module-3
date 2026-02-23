package Session10.Bai7;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        MenuManage manager = new MenuManage();
        Scanner sc  = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("""
                    ========= MENU QUẢN LÝ DANH SÁCH SINH VIÊN ======
                    1. Nhập sinh viên
                    2. In danh sách sinh viên
                    3. Tìm kiếm sinh viên theo tên
                    4. Thoát chương trình
                    =================================================
                    """);
            choice = InputData07.getInt(sc,"Lựa chọn của bạn: ");
            switch(choice) {
                case 1 ->{ // Nhập sinh viên
                    int studentId = InputData07.getInt(sc,"Student ID: ");
                    String studentName = InputData07.getString(sc,"Student Name: ");
                    double gpa = InputData07.getGPA(sc,"GPA: ");
                    manager.add(new Student(studentId,studentName,gpa));
                    System.out.println("Thêm sinh viên thành công ✅");
                }
                case 2 ->{ // In danh sách sinh viên
                    manager.display();
                }
                case 3 ->{ // Tìm kiếm sinh viên theo tên
                    String studentName =  InputData07.getString(sc,"Tên sinh viên cần tìm:  ");
                    for (int i = 0; i <manager.students.size(); i++ ) {
                        if (manager.students.get(i).getStudentName().equals(studentName)) {
                            System.out.println("----Thông tin sinh viên----" +
                                               "\n" +
                                               manager.students.get(i) + "\n" +
                                               "--------------------------");
                        }
                    }
                }
                case 4 ->{
                    System.out.println("Kết thúc chương trình");
                    return;
                }
            }
        }
    }
}
