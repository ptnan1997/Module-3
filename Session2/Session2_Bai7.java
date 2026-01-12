package Session2;

import java.util.Scanner;

public class Session2_Bai7 {
     static void main() {
        Scanner sc = new Scanner(System.in);
         System.out.println("Nhập vào 3 số nguyên dương tương ứng với 3 cạnh của tam giác");
         int a  = Integer.parseInt(sc.nextLine());
         int b = Integer.parseInt(sc.nextLine());
         int c = Integer.parseInt(sc.nextLine());
         if (!(a + b >c) || !(b + c > a) ) {
             System.err.println("Ba cạnh không tạo thành tam giác");
         } else if (a == b && b == c) {
             System.out.println("Tam giác đều");
         } else if (a == b || b == c) {
             System.out.println("Tam giác cân");
         } else if (a*a ==b*b+c*c ||b*b ==a*a+c*c ||c*c ==b*b+a*a) {
             System.out.println("Tam giác vuông");
         } else {
             System.out.println("Tam giác thường");
         }
    }
}
