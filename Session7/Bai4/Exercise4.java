package Session7.Bai4;

import java.util.Scanner;

public class Exercise4 {
    static void main() {
        Student [] studentArray = new Student[5];
        // Tạo danh sách sinh viên
        studentArray[0] = new Student("Alice", 20, "A1", 8.5);
        studentArray[1] = new Student("Bob", 21, "A1", 7.0);
        studentArray[2] = new Student("Charlie", 19, "A2", 9.0);
        studentArray[3] = new Student("David", 22, "A2", 6.5);
        studentArray[4] = new Student("Eve", 20, "A1", 8.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm min: ");
        double min = scanner.nextDouble();
        System.out.print("Nhập điểm max: ");
        double max = scanner.nextDouble();

        // Hiển thị danh sách sinh viên trong khoảng điểm
        System.out.println("Danh sách sinh viên có điểm trung bình từ " + min + " đến " + max + ":");
        for (Student student : studentArray) {
            if (student.getAvgScore() >= min && student.getAvgScore() <= max) {
                System.out.println(student);
            }
        }

        scanner.close();
    }
}
