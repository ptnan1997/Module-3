package Session8.Bai3;

public class Main03 {
    static void main() {
        Circle circle1 = new Circle(3);
        Rectangle reg =  new Rectangle(5, 5);
        Square sq1 = new Square(3,5);

        // Cài đặt màu cho từng hình học sử dụng phương thức
        // set màu đã tạo ở Colorable
        circle1.setColor("Red");
        reg.setColor("Blue");
        sq1.setColor("Green");

        // In lấy giá trị màu của từng loại hình học
        System.out.println("Circle 1: " + circle1.getColor());
        System.out.println("Square 1: " + sq1.getColor());
        System.out.println("Rectangle 1: " + reg.getColor());
    }
}
