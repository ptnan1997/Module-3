package Session9.Bai1.ra.presentation;

import Session9.Bai1.ra.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    private static final int MAX = 100;
    private static Student [] student  = new Student[MAX];
    private static int count = 0;
    private static int indexOfStudent(int id){
        for (int i = 0; i < count; i++){
            if (student[i].getId()==id){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("""
                    ********* QUẢN LÝ SINH VIÊN *******
                    1. Hiển thị danh sách sinh viên
                    2. Thêm sinh viên
                    3. Cập nhật thông tin sinh viên theo mã sinh viên
                    4. Xóa sinh viên theo mã sinh viên
                    5. Tím sinh viên theo tên sinh viên
                    6. Thoát
                    ***********************************
                    """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    if (count == 0){
                        System.out.println("Danh sách sinh viên trống!!");
                        break;
                    }
                    System.out.println("_____ Danh sách sinh viên_____");
                    for (int i = 0; i < count; i++) {
                        student[i].displayData();
                    }
                }
                case 2 -> {
                    if (count >= MAX) {
                        System.out.println("Danh sách đã đầy, không thể thêm!");
                        break;
                    }

                    System.out.println("---- Nhập thông tin sinh viên ----");
                    Student st = new Student();
                    st.inputData(scanner);

                    // kiểm tra trùng mã sinh viên
                    boolean duplicated = false;
                    for (int i = 0; i < count; i++) {
                        if (student[i].getId()==(st.getId())) {
                            duplicated = true;
                            break;
                        }
                    }

                    if (duplicated) {
                        System.out.println("Mã sinh viên đã tồn tại. Thêm thất bại!");
                        break;
                    }

                    student[count++] = st;
                    System.out.println("Thêm sinh viên thành công ✅");
                }

                case 3 -> {
                    if (count == 0){
                        System.out.println("Danh sách sinh viên trống !!");
                        break;
                    }
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    int findID = Integer.parseInt(scanner.nextLine());
                    int found = indexOfStudent(findID);
                    if (found == -1){
                        System.out.println("Sinh viên không tồn tại");
                        break;
                    }

                    Student st = new Student();
                    st.inputData(scanner);
                    student[indexOfStudent(findID)] = st;
                    System.out.println("Cập nhật thành công ✅");
                }
                case 4 -> {
                    if (count ==0){
                        System.out.println("Danh sách sinh viên trống !!");
                        break;
                    }
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    int found = indexOfStudent(idx);
                    if (found == -1){
                        System.out.println("Sinh viên không tồn tại");
                        break;
                    }
                    for  (int i = idx; i < count-1; i++){
                        student[i] = student[i+1];
                    }
                    count--;
                    student[count]=null;
                    System.out.println("Đã xóa thành công ✅");
                }
                case 5 -> {
                    if (count ==0){
                        System.out.println("Danh sách sinh viên trống !!");
                        break;
                    }
                    System.out.print("Nhập tên sinh viên cần tìm:");
                    String findName = scanner.nextLine();
                    for (int i = 0; i < count; i++) {
                        if (student[i].getFullName().equals(findName)) {
                            student[i].displayData();
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Kết thúc chương trình!!. Cảm ơn đã sử dụng.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
