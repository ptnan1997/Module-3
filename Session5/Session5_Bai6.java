package Session5;
import java.util.Scanner;
public class Session5_Bai6 {
    static void main() {
        Scanner  sc = new Scanner (System.in);
        while (true) {
            System.out.print("Nhập vào email của bạn: ");
            String email = sc.nextLine();

            System.out.print("Nhập vào mật khẩu của bạn: ");
            String password = sc.nextLine();

            if (email.isEmpty() || password.isEmpty()) {
                System.err.println("Vui lòng nhập lại thông tin");
                continue;
            }
                if (isValidPassword(password)) {
                    String hiddenPass = password.replaceAll(".","*");
                    System.out.printf("Email: %s \n", email);
                    System.out.printf("Mật khẩu: %s \n",hiddenPass);
                    System.out.println("Mật khẩu hợp lệ ✅");
                    break;
                } else {
                    System.out.println("Mật khẩu không hợp lệ.❌ Vui lòng nhập lại");

                }
        }

    }
    public static boolean isValidPassword(String password) {
        final String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";
        return password.matches(regex);
    }
}
