package Session11.Bai5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("""
                    ===== QUAN LY SU KIEN =====
                    1. Them su kien
                    2. Hien thi danh sach su kien
                    3. Thoat
                    ===========================
                    """);

            System.out.print("Lua chon cua ban: ");
            String choiceStr = sc.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                System.out.println("❌ Vui long nhap so (1-3)!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ten su kien: ");
                    String name = sc.nextLine().trim();

                    LocalDateTime start;
                    while (true) {
                        System.out.print("Nhap thoi gian bat dau (dd/MM/yyyy HH:mm): ");
                        String startStr = sc.nextLine();
                        try {
                            start = LocalDateTime.parse(startStr, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("❌ Sai dinh dang! VD: 24/02/2026 18:30");
                        }
                    }

                    LocalDateTime end;
                    while (true) {
                        System.out.print("Nhap thoi gian ket thuc (dd/MM/yyyy HH:mm): ");
                        String endStr = sc.nextLine();
                        try {
                            end = LocalDateTime.parse(endStr, formatter);

                            if (!end.isAfter(start)) {
                                System.out.println("❌ Thoi gian ket thuc phai SAU thoi gian bat dau!");
                                continue;
                            }
                            break;

                        } catch (DateTimeParseException e) {
                            System.out.println("❌ Sai dinh dang! VD: 24/02/2026 20:00");
                        }
                    }

                    events.add(new Event(name, start, end));
                    System.out.println("✅ Them su kien thanh cong!");
                }

                case 2 -> {
                    if (events.isEmpty()) {
                        System.out.println("Danh sach dang trong!");
                    } else {
                        System.out.println("===== DANH SACH SU KIEN =====");
                        for (int i = 0; i < events.size(); i++) {
                            System.out.println((i + 1) + ". " + events.get(i));
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Tam biet!");
                    return;
                }

                default -> System.out.println("❌ Lua chon khong hop le!");
            }
        }
    }
}
