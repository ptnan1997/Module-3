package Session7.Bai1;

import java.util.Scanner;

public class Exercise1 {
    static void main() {
        // Tạo đối tượng Rectangle với constructor mặc định
        Rectangle rect1 = new Rectangle();
        System.out.println("Hình chữ nhật 1:");
        rect1.display();

        // Tạo đối tượng Rectangle với constructor có tham số
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chiều dài: ");
        double length = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập vào chiều rộng: " );
        double width = Double.parseDouble(sc.nextLine());
        Rectangle rect2 = new Rectangle(width, length);
        System.out.println("\nHình chữ nhật 2:");
        rect2.display();
    }
}
