package Session2;
import java.util.Scanner;
public class Session2_Bai6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên bất ký từ bàn phím");
        int number = Integer.parseInt(sc.nextLine());
        if  (number <0) {
            number = Math.abs(number);
        }
        int sum = 0;
        while (number>0){
           int digit = number % 10;
            sum += digit;
            number =  number / 10;
        }
        System.out.printf("Tổng các số trong dãy số là %d",sum);
        sc.close();
    }
}
