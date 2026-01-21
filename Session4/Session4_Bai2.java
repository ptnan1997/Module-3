package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai2 {
     static void main() {
        Scanner sc = new Scanner(System.in);
         System.out.println("Nhập kích thước mảng");
         int size = sc.nextInt();
        int [] arr =  new  int[size];
        int sum = 0;
         System.out.println("Nhập các phần tử cho mảng");
        for  (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
         System.out.println(Arrays.toString(arr));
         System.out.printf("Tổng các phần tử trong mảng là: %d",sum);
    }
}
