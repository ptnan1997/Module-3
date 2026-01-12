package Session2;
import  java.util.Scanner;
public class Session2_Bai2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 số nguyên từ 1 đến 7 ");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Chủ nhật");
                break;
            case 2:
                System.out.println("Thứ Hai");
                break;
            case 3:
                System.out.println("Thứ Ba");
                break;
            case 4:
                System.out.println("Thứ Tư");
                break;
            case 5:
                System.out.println("Thứ Năm");
                break;
            case 6:
                System.out.println("Thứ Sáu");
                break;
            case 7:
                System.out.println("Thứ Bảy");
                default:
                    System.out.println("Số nhập vào không hợp lệ");
                    break;
        }
    }
}
