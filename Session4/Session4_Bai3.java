package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai3 {
    static void main() {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng:");
        int size = sc.nextInt();
        int [] arr = new  int[size];
        System.out.println("Nhập các phần tử cho mảng");
        for   (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Mảng trước khi sắp xếp:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i<arr.length-1; i++){
           for (int j = 0; j< arr.length-i-1; j++){
               if (arr[j]<arr[j+1]){
                   int tem =  arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=tem;
               }
           }
        }
        System.out.println("Mảng sau khi sắp xếp:");
        System.out.println(Arrays.toString(arr));

    }
}
