package Bai7.presentation;

import Bai7.ra.dao.HotelManager;
import Bai7.ra.entity.Booking;

import java.sql.Date;
import java.util.Scanner;


public class Main07 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        HotelManager manager =  new HotelManager();
        int choice;
        do {
            System.out.println("""
                    ========= QUẢN LÝ ĐẶT PHÒNG KHÁCH SẠN =======
                    1. Đặt phòng
                    2. Hủy đặt phòng
                    3. Hiển thị danh sách các phòng còn trống
                    4. Thoát
                    =============================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập mã phòng: ");
                    int roomId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = sc.nextLine();
                    System.out.print("Nhập ngày bắt đầu");
                    Date startDate;
                    while (true) {
                        try {
                            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                            startDate = Date.valueOf(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Sai định dạng! Vui lòng nhập lại theo yyyy-MM-dd");
                        }
                    }
                    System.out.print("Nhập ngày kết thúc: ");
                    Date endDate;
                    while (true) {
                        try {
                            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                            endDate = Date.valueOf(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Sai định dạng! Vui lòng nhập lại theo yyyy-MM-dd");
                        }
                    }
                    manager.bookRoom(new Booking(roomId,customerName,startDate,endDate));
                }
                case 2 -> {
                    System.out.print("Nhập bookingId bạn muốn hủy: ");
                    int bookingId = Integer.parseInt(sc.nextLine());
                    manager.cancelBooking(bookingId);
                }
                case 3 -> manager.listAvailableRooms();
                case 4 -> System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
            }
        } while (choice != 4);
    }
}
