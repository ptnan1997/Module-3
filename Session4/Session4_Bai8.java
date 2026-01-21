package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai8 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int value = 1;
        System.out.print("Enter integer number: ");
        int n = sc.nextInt();
        if (n<=0){
            System.err.println("Ma trận không hợp lệ");
            return;
        }
        int [][] arr = new  int [n][n];
        for  (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = value++;
            }
        }
        System.out.println("Ma trận ban đầu:");
        System.out.println(Arrays.deepToString(arr));

        transpose (arr,n);
        reverseColumns(arr,n);
        System.out.println("Ma trận sau khi xoay 90 độ theo chiều kim đồng hồ:");
        System.out.println(Arrays.deepToString(arr));

    }
    // Chuyển vị ma trận [i][j] thàng [j][i]
    static void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    // Đảo ngược các cột ( hoán đổi cột trái --> cột phải)
    static void reverseColumns(int[][] matrix, int n) {
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
