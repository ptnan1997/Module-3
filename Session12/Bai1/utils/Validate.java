package Session12.Bai1.utils;

import java.util.Scanner;

public class Validate {

    // Nhập String có độ dài min-max
    public static String inputStringLength(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();

            if (s.length() < min || s.length() > max) {
                System.out.println("Chuỗi phải từ " + min + " đến " + max + " ký tự!");
                continue;
            }
            return s;
        }
    }

    // Nhập float > 0
    public static float inputPositiveFloat(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                float x = Float.parseFloat(sc.nextLine());
                if (x <= 0) {
                    System.out.println("Giá trị phải > 0!");
                    continue;
                }
                return x;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    // Nhập int >= 0
    public static int inputNonNegativeInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int x = Integer.parseInt(sc.nextLine());
                if (x < 0) {
                    System.out.println("Giá trị phải >= 0!");
                    continue;
                }
                return x;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    // Nhập String tối đa max ký tự (cho category)
    public static String inputStringMax(Scanner sc, String message, int max) {
        while (true) {
            System.out.print(message);
            String s = sc.nextLine().trim();

            if (s.length() > max) {
                System.out.println("Chuỗi tối đa " + max + " ký tự!");
                continue;
            }
            return s;
        }
    }
}
