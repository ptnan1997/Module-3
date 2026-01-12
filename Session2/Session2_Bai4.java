package Session2;
import java.util.Scanner;
public class Session2_Bai4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
       int age = 0;
       do {
           System.out.println("Nhập vào số tuổi của bạn");

           if(sc.hasNextInt()){
               age  = sc.nextInt();
            if (age <= 0 ) {
                System.err.println("Vui lòng nhập vào số nguyên và lớn hơn không");
            }
           } else {
               System.err.println("Vui lòng nhập vào số nguyên");
                sc.next();

            }

       } while (age <=0);
        System.out.printf("Tuổi của bạn là %s !%n",age);
       sc.close();
    }
}
