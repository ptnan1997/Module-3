package Session6;
import java.util.Scanner;


public class Session6_Bai2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        boolean isContinued = true;

        String userName = "";
        String password ="";
        String email ="";
        String phone ="";
        while(isContinued) {
            System.out.print("""
                    ************** QUẢN LÝ NGƯỜI DÙNG **************
                    1. Nhập thông tin người dùng
                    2. Chuẩn hóa họ tên
                    3. Kiểm tra email hợp lệ
                    4. Kiểm tra số điện thoại hợp lệ
                    5. Kiểm tra mật khẩu hợp lệ
                    6. Thoát
                    ************************************************
                    """);
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("""
                ==== Nhập thông tin người dùng ====
                   Các thông tin sau bao gồm: Họ tên, Email, Điện thoại, Mật khẩu
                """);
                    System.out.print("Họ và tên: ");
                    userName = sc.nextLine();
                    System.out.print("Email: ");
                    email = sc.nextLine();
                    System.out.print("Phone number: ");
                    phone = sc.nextLine();
                    System.out.print("Password: ");
                    password = sc.nextLine();
                    String hiddenPass = "*".repeat(password.length());
                    System.out.printf("""
                            Các thông tin đã nhập của bạn như sau:
                                Username: %s
                                Email : %s
                                Phone : %s
                                Password :%s
                            """, userName, email, phone, hiddenPass);
                    System.out.print("Bạn có muốn hủy nhập thông tin không? (Có/Không): ");
                    String cancelButton = sc.nextLine();
                    if (cancelButton.trim().equalsIgnoreCase("Có")) {
                        userName = "";
                        password = "";
                        email = "";
                        phone = "";
                        System.out.println("Đã hủy nhập thông tin ❌");
                    } else if (cancelButton.trim().equalsIgnoreCase("Không")) {
                        System.out.println("Điền thông tin thành công ✅");
                    } else{
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 2:
                    if (userName.isEmpty()){
                    System.err.println("⚠️ Chưa có username. Vui lòng nhập ở case 1.");
                    break;
                    }
                    // Bước 1: Loại bỏ khoảng trắng dư đầu/cuối và giữa các từ
                    String normalized = userName.trim().replaceAll("\\s+", " ");

                    // Bước 2: Tách họ tên thành từng từ
                    String[] parts = normalized.split(" ");

                    // Bước 3: Chuẩn hóa từng từ
                    StringBuilder result = new StringBuilder();
                    for (String p : parts) {
                        if (!p.isEmpty()) {
                            result.append(
                                    p.substring(0, 1).toUpperCase()
                                            .concat(p.substring(1).toLowerCase())
                            ).append(" ");
                        }
                    }

                    // Bước 4: Gán lại họ tên đã chuẩn hóa
                    userName = result.toString().trim();

                    // Hiển thị kết quả
                    System.out.println("✅ Họ tên sau khi chuẩn hóa: " + userName);
                    break;
                case 3:
                    if (email.isEmpty()) {
                        System.out.println("⚠️ Chưa có email. Vui lòng nhập ở case 1.");
                        break;
                    }
                    if (!isValidEmail(email)){
                        System.out.println("Email không đúng định dạng ❌");
                    } else {
                        System.out.println("Email hợp lệ ✅");
                    }
                    break;
                case 4:
                    if (phone.isEmpty()) {
                        System.out.println("⚠️ Chưa có số điện thoại. Vui lòng nhập ở case 1.");
                        break;
                    }
                    if(!isValidPhone(phone)){
                        System.out.println("Số điện thoại không hợp lệ ❌");
                    } else {
                        System.out.println("Số điện thoại hợp lệ ✅");
                    }
                    break;
                case 5:
                    if(password.isEmpty()){
                        System.out.println("⚠️ Chưa có mật khẩu. Vui lòng nhập ở case 1.");
                        break;
                    }
                    if (!isValidPassword(password)){
                        System.out.println("Mật khẩu không hợp lệ ❌");
                    } else {
                        System.out.println("Mật khẩu hợp lệ ✅");
                    }
                    break;
                case 6:
                    System.out.println("👋 Thoát chương trình. Tạm biệt!");
                    isContinued = false;
                    break;
                    default:
                        System.out.println("❌ Lựa chọn không hợp lệ, vui lòng chọn lại.");
                        break;
            }
        }
    }
    // CÁC THUẬT TOÁN CHECK VALIDATE
    public static boolean isValidEmail (String email) {
        return  email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    public static boolean isValidPhone (String phone) {
        return phone.matches("^\\d{10,11}$");
    }
    public static boolean isValidPassword (String password) {
        return password.matches("^[A-Za-z0-9]{6,}$");
    }
}
