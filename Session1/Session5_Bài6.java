package Session1;
import java.util.Scanner;
public class Session5_Bài6 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều rộng");
        float width = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập vào chiều cao");
        float height =  Float.parseFloat(sc.nextLine());
        double area  =  width*height;
        double circumference  = 2 *(width+height);
        System.out.println("Diện tích hình chữ nhật:" + area);
        System.out.println("Chu vi hình chữ nhật :" + circumference);
    }
}
