import java.util.Scanner;
void main() {
    final float PI = 3.14f;
    Scanner sc = new Scanner(System.in);

    System.out.println("Nhập bán kính đường tròn để tính chu vi");
    double banKinh = sc.nextDouble();
    double dienTich = Math.pow(banKinh, 2) * PI;
    System.out.println("Diện tích của hình tròn là:"+ dienTich);
}