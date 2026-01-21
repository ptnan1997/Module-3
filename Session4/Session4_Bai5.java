package Session4;

import java.util.Scanner;
public class Session4_Bai5 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Nhập vào kích thước hàng");
        int rowSize =  sc.nextInt();
        System.out.println("Nhập vào kích thước cột");
        int colSize = sc.nextInt();
        int[][] arr2d = new int[rowSize][colSize];
        int sumEven = 0;
        int sumOdd = 0;
        System.out.println("Nhập giá trị cho mảng theo từng hàng");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                arr2d[i][j] = sc.nextInt();
                if (arr2d[i][j] %2 == 0) {
                    sumEven += arr2d[i][j];
                } else {
                    sumOdd += arr2d[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: "+sumEven);
        System.out.println("Tổng các số lẻ: "+sumOdd);
    }
}
