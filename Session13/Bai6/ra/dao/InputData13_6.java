package Session13.Bai6.ra.dao;

import Session13.Bai6.ra.entity.Tasks.Status;

import java.util.Scanner;

public class InputData13_6 {
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
    public static Status getStatus(Scanner scanner, String suggest) {
        while (true){
            try{
                System.out.print(suggest);
                String input = scanner.nextLine().toUpperCase();
                return Status.valueOf(input);
            } catch (IllegalArgumentException e){
                System.out.println("Trạng thái không hợp lệ! Vui lòng nhập lại");
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
}
