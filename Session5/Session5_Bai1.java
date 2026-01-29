package Session5;
import java.util.Scanner;

public class Session5_Bai1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your string: ");
        String str1 = sc.nextLine();
        System.out.println("Please enter your finding word: ");
        String str2 = sc.nextLine();
        int index = str1.indexOf(str2);
        if(index == -1){
            System.out.println("Invalid string");
        } else {
            System.out.printf("Từ %s xuất hiện tại vị trí %d trong chuỗi",str2,index);
        }
    }
}
