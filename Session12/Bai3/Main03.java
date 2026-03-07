package Session12.Bai3;

import Session12.Bai3.ra.business.OrderBusiness;
import Session12.Bai3.ra.entity.Order;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderBusiness manager = new OrderBusiness();
        int choice;
        do {
            System.out.println("""
                    *********************QUẢN LÝ ĐƠN HÀNG********************
                    
                    1.Thêm đơn hàng
                    2.Hiển thị danh sách đơn hàng
                    3.Cập nhật trạng thái đơn hàng theo mã đơn hàng
                    4.Xóa đơn hàng theo mã đơn hàng
                    5.Tìm kiếm đơn hàng theo tên khách hàng
                    6.Thống kê tổng số đơn hàng
                    7.Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered
                    8.Thống kê số lượng đơn hàng theo từng trạng thái
                    9.Tìm kiếm đơn hàng có giá trị lớn nhất
                    10.Thoát
                    Lựa chọn của bạn:
                    """);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> //1.Thêm đơn hàng
                    manager.addOrder();

                case 2 -> //2.Hiển thị danh sách đơn hàng
                    manager.displayOrdersDescByAmoutn();

                case 3 ->{ // Cập nhật trạng thái đơn hàng theo mã đơn hàng
                    System.out.print("Nhập vào mã đơn hàng bạn muốn cập nhật trạng thái: ");
                    int id = Integer.parseInt(sc.nextLine());
                    manager.updateStatusByID(id,sc);
                }
                case 4 ->{ // Xóa đơn hàng theo mã đơn hàng
                    System.out.print("Nhập vào mã đơn hàng bạn muốn xóa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    manager.deleteByID(id);
                }
                case 5 ->{ // Tìm kiếm đơn hàng theo tên khách hàng
                    System.out.print("Nhập vào tên khách hàng để tìm đơn hàng: ");
                    String name = sc.nextLine();
                    manager.findOrderByCustomerName(name);
                }
                case 6 -> // Thống kê tổng số đơn hàng
                    manager.StatisticTotalOrders();

                case 7 -> // Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered
                    manager.calculateDeliveredRevenue();

                case 8 ->{ //Thống kê số lượng đơn hàng theo từng trạng thái
                    System.out.print("Nhập vào trạng thái bạn muốn thống kê: ");
                    String input =  sc.nextLine().trim().toUpperCase();
                    Order.Status status = Order.Status.valueOf(input);
                    manager.calAmountOfOrders(status);
                }
                case 9 -> // Tìm đơn hàng có giá trị lớn nhất
                    manager.findMostValueOfOrders();

                case 10 ->{
                    System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}
