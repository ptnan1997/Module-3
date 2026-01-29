package Session5;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuilder;
public class Session5_Bai3 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi ngẫu nhiên");
        String str = sc.nextLine();

       // Khai báo biến để lưu kết quả sau khi thay đổi
        String changeStr = str.replaceAll("[0-9]","*");
      System.out.printf(changeStr);

    }
}
