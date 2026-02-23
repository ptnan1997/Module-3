package Session10.Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        ArrayList<Student>  students = new ArrayList<>();
        System.out.println("Nhập tên sinh viên");

        while (true) {
            System.out.println("""
                    ====== QUẢN LÝ SINH VIÊN =====
                    1. Thêm sinh viên
                    2. Hiển thị danh sach sinh viên
                    3. Thoát
                    ==============================
                    Lựa chọn của bạn:
                    """);
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }
            switch (choice){
                case 1 -> {
                    // ===== Nhập studentId =====
                    int idStudent;
                    while (true) {
                        System.out.print("Nhập studentID: ");
                        try {
                            idStudent = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("❌ ID phải là số nguyên!");
                        }

                        }


                    // ===== Nhập tên =====
                    String name;
                    while (true) {
                        System.out.print("Nhập tên: ");
                        name = sc.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("❌ Tên không được để trống!");
                        } else {
                            break;
                        }
                    }

                    // ===== Nhập điểm trung bình =====
                    double avg;
                    while (true) {
                        System.out.print("Nhập điểm trung bình (0-10): ");
                        try {
                            avg = Double.parseDouble(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("❌ Điểm phải là số!");
                            continue;
                        }

                        if (avg < 0 || avg > 10) {
                            System.out.println("❌ Điểm phải từ 0 đến 10!");
                        } else {
                            break;
                        }
                    }
                    students.add(new Student(idStudent,name,avg));
                    System.out.println("✅ Thêm sinh viên thành công!");
                }
                case  2 -> {
                    if (students.isEmpty()) {
                        System.out.println("📌 Danh sách trống.");
                    } else {
                        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Kết thúc chương trình");
                    sc.close();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
