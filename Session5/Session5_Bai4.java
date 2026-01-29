package Session5;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Session5_Bai4 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        System.out.print("Nhập vào email của bạn: ");
        String str = sc.nextLine().trim();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$");
        Matcher matcher = pattern.matcher(str);
        boolean result =  matcher.matches();
        System.out.printf("Email %s",result?"Hợp lệ":"Không hợp lệ");
    }

}
