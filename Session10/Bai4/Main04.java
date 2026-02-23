package Session10.Bai4;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendantManager attendantManager = new AttendantManager();
        int choice;
        while (true) {
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ ĐIỂM DANH ***************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

            choice = InputData3.getInt(sc ,"Lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    // Thêm sinh viên
                    String id = InputData3.getString(sc ,"Nhập id sinh viên : ");
                    String name = InputData3.getString(sc,"Nhập tên sinh viên: ");
                    int age = InputData3.getInt(sc,"Nhập tuổi sinh viên: ");
                    String gender = InputData3.getString(sc,"Nhập giới tính (Nam/Nữ): ");
                    Student student = new Student(id,name,age,gender);
                    attendantManager.add(student);
                    System.out.println("Sinh viên đã được thêm thành công.");
                    break;

                case 2:
                    // Sửa sinh viên
                    attendantManager.display();
                    String idStudent = InputData3.getString(sc,"Nhập id sinh viên cần sửa: ");
                    int index = -1 ;
                    for (int i = 0 ; i < attendantManager.Student.size() ; i++) {
                        if(attendantManager.Student.get(i).getStudentId().equals(idStudent)) {
                            index = i;
                            break;
                        }
                    }
                    if(index == -1) {
                        System.out.println("Không tìm thấy sinh viên cần sửa !");
                    }else {

                        String newName = InputData3.getString(sc,"Nhập tên mới sinh viên: ");
                        int newage = InputData3.getInt(sc,"Nhập vào số tuổi (mới): ");
                        String newgender = InputData3.getString(sc, "Nhập vào giới tính(mới): ");
                        attendantManager.update(index, new Student(idStudent,newName,newage, newgender));
                        System.out.println("Sinh viên đã được sửa thành công.");
                    }
                    break;

                case 3:
                    // Xóa sinh viên
                    attendantManager.display();
                    String idDelete = InputData3.getString(sc,"Nhập id sinh viên cần xóa: ");
                    int indexDelete = -1 ;
                    for (int i = 0 ; i < attendantManager.Student.size() ; i++) {
                        if(attendantManager.Student.get(i).getStudentId().equals(idDelete) ) {
                            indexDelete = i;
                            break;
                        }
                    }
                    if(indexDelete == -1) {
                        System.out.println("Không tìm thấy sinh viên cần xóa !");
                    }else {
                        attendantManager.delete(indexDelete);
                        System.out.println("Đã xóa thành công sinh viên !");
                    }

                    break;

                case 4:
                    // Hiển thị danh sách sinh viên
                    attendantManager.display();
                    break;

                case 5:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
