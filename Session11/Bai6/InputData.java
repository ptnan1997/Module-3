package Session11.Bai6;

import Session10.Bai2.inputData;
import Session11.Bai3.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    Scanner sc = new Scanner(System.in);

    public static String getString(Scanner scanner, String suggest) {
        return inputData.getString(scanner, suggest);
    }

    public static int getInt(Scanner scanner, String suggest) {
        String rs;

        do {
            System.out.println(suggest);
            rs = scanner.nextLine();
            try {
                if (rs.isEmpty()) {
                    System.out.println("Vui lòng ko bỏ trống !");
                } else if (Integer.parseInt(rs) < 0) {
                    System.out.println(" Vui lòng nhập số nguyên >= 0 !");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(" Vui lòng nhập số nguyên >= 0 !");
            }


        } while (true);
        return Integer.parseInt(rs);
    }
}
