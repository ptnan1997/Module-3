package Session2;
import  java.util.Scanner;
public class Session2_Bai9 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int N;
        do {
            System.out.println("Nhập vào một số nguyên dương");
             N =  sc.nextInt();
             if(N <0){
                 System.err.println("Vui lòng không được nhập số âm");
             }
        } while(N <0);
        for (int i = 0; i <= N; i++) {
            int k = 0;
            double sum = 0;
            int number = i;
            while (number > 0) {
                number = number /10;
                k++;
            }
            number = i;
            while (number > 0) {
                int digit =  number % 10;
                number = number / 10;
                sum = sum + Math.pow(digit,k);
            }
            number = i;
            if (sum == i){
                System.out.println(number);
            }
        }
    }
}
// B1 : khai biến n  với giá trị nhập vào từ bàn phím
// B2 :  duyệt từ 1 -> n để tìm ra những số armstrong và in ra
//	        - khai báo biến countNumber để đếm số lượng chữ số của số đang muốn kiểm tra = 0;
//          - Khai báo biến sum để tính tổng của các chữ số nhân với lũy thừa countNumber
//          - khai báo 1 biến tạm tmp với giá trị = i ;
// - sư dụng vòng lặp while để tách và đếm từng chữ số của số cần kiểm tra => điều kiện tmp > 0
//				- tmp = tmp / 10 ;
//					k++ ;
//			- gán lại tmp = i ;
//			- phân tách từng chữ số để lũy thừa k => sư dụng vòng lặp while để tách
//			và đếm từng chữ số của số cần kiểm tra => điều kiện tmp > 0
//				- khai báo biến charNumber = tmp % 10 ;
//                - cập nhật lại tmp = tmp / 10
//                - cập nhật sum += math.pow(charNumber,countNumber);
//			- Kiểm sum == i
//				+ nếu bằng thì in ra i