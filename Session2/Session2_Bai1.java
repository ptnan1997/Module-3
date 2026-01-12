package Session2;
import java.util.Scanner;
public class Session2_Bai1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        boolean isCheck = true;
        while (isCheck) {
            System.out.println("Nhập vào số nguyên");
            float number = Integer.parseInt(sc.nextLine());
            if (number == 0){
                System.out.println("Số không phải là số chẳn cũng không phải lẻ");
            } else
            if (number == -1) {
                isCheck = false;
                System.out.println("Thoát khỏi chương trình");
            } else if (number % 2 == 0) {
                System.out.println("Số bạn nhập là số chẵn");
            } else if (number % 2 != 0){
                 System.out.println("Số bạn nhập là số lẻ");

            }
        }

    }
}
