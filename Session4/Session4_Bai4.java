package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước cho mảng");
        int size = sc.nextInt();
        int [] arr =  new  int[size];
        System.out.println("Nhập giá trị từng phần tử của mảng");
        for (int i = 0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Mảng trước khi đảo:");
        System.out.println(Arrays.toString(arr));
        if (arr.length == 0){
            System.err.println("Kích thước rỗng");
        }else {
            for  (int i=0;i<=(size-1)/2;i++) {
                    int  temp = arr[i];
                    arr[i] = arr[size-i-1];
                    arr[size-i-1] = temp;
            }
        }
        System.out.println("Mảng sau khi đảo");
        System.out.println(Arrays.toString(arr));
    }
}
