package Session13.Bai8.ra.dao;


import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputData13_8 {
    public static String getString(Scanner scanner, String suggest) {
        while (true) {
            System.out.print(suggest);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.err.println("Chuỗi không được để trống!");
        }
    }
    public static Year getYear(Scanner scanner, String suggest) {
        while (true){
            try{
                System.out.print(suggest);
                return Year.parse(scanner.nextLine());
            } catch(
                    DateTimeParseException e){
                System.out.println("Năm không hợp lệ! Vui lòng nhập lại");
            }
        }
    }
    public static int  getInt(Scanner scanner, String suggest) {
        while (true){
            try {
                System.out.print(suggest);
                int input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    System.out.println("Vui lòng nhập số nguyên lớn hơn 0");
                    continue;
                }
                return input;
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào số nguyên !");
            }
        }
    }
    public static double getDouble(Scanner scanner, String suggest) {
        while (true) {
            try {
                System.out.print(suggest);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Số không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }
}
