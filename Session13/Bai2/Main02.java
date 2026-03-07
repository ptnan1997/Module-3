package Session13.Bai2;

import Session13.Bai2.ra.dao.StudentImpl;
import Session13.Bai2.ra.entity.Student;

import java.sql.Date;
import java.time.LocalDate;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentImpl studentImpl = new StudentImpl();
        do {
            System.out.println("""
                    ============ MENU ===========
                    1. Hiển thị danh sách sinh viên
                    2. Thêm sinh viên mới
                    3. Sửa sinh viên
                    4. Xóa sinh viên
                    5. Tìm kiếm sinh viên
                    6. Thoát
                    =============================
                    Lựa chọn của bạn :
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> //Hiển thị danh sách sinh viên
                    studentImpl.getAllStudents();

                case 2 ->{//Thêm sinh viên mới
                    System.out.print("Nhập tên sinh viên: ");
                    String full_name = sc.nextLine();
                    System.out.print("Nhập ngày tháng năm sinh (YYYY-MM-DD): ");
                    String dateOfBirth = sc.nextLine();
                    Date sqlDate = Date.valueOf(dateOfBirth);
                    System.out.print("Nhập Email: ");
                    String email = sc.nextLine();
                    studentImpl.addStudent(new Student(full_name,sqlDate,email));
                }
                case 3 ->{//Sửa sinh viên
                    studentImpl.getAllStudents();


                    System.out.println("Nhập mã sinh viên cần sửa: ");
                    int editstudentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên sinh viên:");
                    String fullNameEdit = sc.nextLine();
                    System.out.print("Nhập ngày tháng năm sinh (YYYY-MM-DD): ");
                    String dateOfBirthEdit = sc.nextLine();
                    Date sqlDate = Date.valueOf(dateOfBirthEdit);
                    System.out.print("Nhập Email: ");
                    String email = sc.nextLine();
                    studentImpl.editStudent(new  Student(fullNameEdit,sqlDate,email),editstudentId);
                }
                case 4 ->{// Xóa sinh viên
                    studentImpl.getAllStudents();
                    System.out.println("Nhập mã sinh viên cần xóa:");
                    int studentIdDelete = Integer.parseInt(sc.nextLine());
                    studentImpl.deleteStudentByID(studentIdDelete);
                }
                case 5 ->{//Tìm kiếm sinh viên
                    studentImpl.getAllStudents();
                    System.out.println("Nhập mã sinh viên cần tìm: ");
                    int studentId = Integer.parseInt(sc.nextLine());
                    Student findStudent = studentImpl.findById(studentId);
                    System.out.println(findStudent);
                }
                case 6 ->{
                    System.out.println("Kết thúc chương trình. Xin cảm ơn đã sử dụng");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}
