package Session11.Bai6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager ChatManager =  new Manager();
        while (true){
            System.out.println("""
                    ======= Ứng dụng chat =======
                    1. Gửi tin nhắn
                    2. Hiển thị lịch sử tin nhắn
                    3. Lọc tin nhắn theo người gửi
                    4. Lọc tin nhắn theo ngày
                    5. Thoát
                    """);
            int choice = InputData.getInt(sc,"Lựa chọn của bạn:");
            switch  (choice){
                case 1 ->{
                    String sender = InputData.getString(sc, "Nhập tên người gửi: ");
                    String content = InputData.getString(sc,"Nhập nội dung bạn muốn gửi: ");
                    ChatManager.SendMessage(sender,content);
                }
                case 2 ->{
                    ChatManager.History();
                }
                case 3 ->{
                    String sender = InputData.getString(sc,"Nhập vào tên người gửi: ");
                    ChatManager.filterBySender(sender);
                }
                case 4 -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (true) {
                        System.out.print("Nhập ngày cần lọc (dd/MM/yyyy): ");
                        String inputDate = sc.nextLine();

                        try {
                            LocalDate date = LocalDate.parse(inputDate, formatter);

                            // convert LocalDate thành LocalDateTime để truyền vào Manager
                            ChatManager.filterByDate(date);
                            break;

                        } catch (DateTimeParseException e) {
                            System.out.println("❌ Sai định dạng ngày! Ví dụ đúng: 25/02/2026");
                        }
                    }
                }
                case 5 ->{
                    System.out.println("Kết thúc chương trình ");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ");
            }

        }
    }
}
