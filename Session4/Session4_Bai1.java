package Session4;

import java.util.Arrays;
import  java.util.Scanner;

public class Session4_Bai1 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        int[] arr = new  int[5];
        for  (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ "+(i+1)+":");
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }
}