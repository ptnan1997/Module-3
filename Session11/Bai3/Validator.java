package Session11.Bai3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {
    public static LocalDateTime getDateTime(Scanner scanner , String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.println(suggest);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input,formatter);
            }catch (Exception e) {
                System.out.println("Enter not valid date");
            }
        }while (true);
    }
}
