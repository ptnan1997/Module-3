package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai7 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int length = sc.nextInt();
        if (length <= 0) {
            System.err.println("Please enter a positive integer");
        }
        int [] arr =  new int[length];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < length; i++){
            arr [i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        // Tạo một biến để ktr nếu toàn bộ giá trị có
        // phải là độc nhất hay không?
        boolean hasUnique = false;
        // Lặp qua từng phần tử trong mảng
        for (int i = 0; i < length; i++){
            int count = 0;
            for(int j = 0; j < length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if (count == 1){
                System.out.print(arr[i]+ " ");
                hasUnique = true;
            }
        }
        if (!hasUnique){
            System.err.println("This Array dont have unique element");
        }

    }
}

