package Session2;
import java.util.Scanner;
public class Session2_Bai3 {
     static void main() {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên dương");
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 0 ){
            System.err.println("Số nhập vào không hợp lệ");
        } else {
            int sum = 0;
            for (int i = 1; i<=n; i++){
                sum = sum + i;
            }
            System.out.printf("Tổng các số từ đến %d là %d",n,sum);
        }
    }
}

