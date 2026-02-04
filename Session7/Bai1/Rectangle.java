package Session7.Bai1;

public class Rectangle {
    private final double width;
    private final double length;
    // Constructor mặc định
    public Rectangle(){
        this.width = 1;
        this.length = 1;
    }
    // Constructor có tham số
    public Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }
    public double getArea() {
        return width * length;
    }
    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
