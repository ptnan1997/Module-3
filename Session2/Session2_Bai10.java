package Session2;
import java.util.Scanner;
public class Session2_Bai10 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên dương");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            int currentNumber = i;
            while (currentNumber != 1 && currentNumber != 4) {
                int sum = 0;
                int temp = currentNumber;
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += (int) Math.pow(digit, 2);
                    temp  /= 10;
                }
                currentNumber = sum ;
            }
            if(currentNumber == 1 ){
                System.out.printf("%d\n",i);
            }
        }
    }
}