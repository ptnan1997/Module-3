package Session10.Bai6;

import java.util.Scanner;

public class Main06 {
    static void main() {
        OrderManager manager  = new OrderManager();
        Scanner sc  = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("""
                    -------- QUẢN LÝ HÓA ĐƠN -------
                    1. Thêm hóa đơn
                    2. Sửa hóa đơn
                    3. Xóa hóa đơn
                    4. Hiển thị danh sách hóa đơn
                    5. Thoát
                    --------------------------------
                    """);
            choice = InputData6.getInt(sc,"Lựa chọn của bạn: ");
            switch (choice) {
                case 1 ->{ // Thêm đơn hàng
                    String orderId = InputData6.getString(sc,"Order ID: ");
                    String orderName = InputData6.getString(sc,"Order Name: ");
                    for (Order o : manager.orders) {
                        if (o.getOrderId().equals(orderId)) {
                            System.out.println("Đã có mã đơn hàng trong danh sách");
                            return;
                        }
                    }
                    manager.add(new Order(orderId,orderName));
                    System.out.println("Đã thêm đơn hàng thành ✅");
                }
                case 2 ->{ // Sửa đơn hàng
                    String updateOrderId =  InputData6.getString(sc,"Update Order ID: ");
                    int index = -1;
                    for (int i = 0; i<manager.orders.size(); i++) {
                        if (manager.orders.get(i).getOrderId().equals(updateOrderId)) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Không có mã đơn hàng trong danh sách");
                    } else {
                        String newCustomerName =  InputData6.getString(sc,"New Custormer Name: ");
                        manager.update(index,new Order(updateOrderId,newCustomerName));
                        System.out.println("Sửa thành công ✅");
                    }
                }
                case 3 ->{ // Xóa đơn hàng
                    String deleteOrderId =   InputData6.getString(sc,"Delete Order ID: ");
                    int index = -1;
                    for (int i = 0; i<manager.orders.size(); i++) {
                        if (manager.orders.get(i).getOrderId().equals(deleteOrderId)) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Không có mã đơn hàng trong danh sách");
                    } else {
                        manager.delete(index);
                        System.out.println("Đã xóa thành công đơn hàng ✅");
                    }
                }
                case 4 ->{ //Hiển thị danh sách đơn hàng
                    manager.display();
                }
                case 5 ->{ // Thoát
                    System.out.println("Kết thúc chương trình! Cảm ơn đã sứ dụng.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!!");
            }
        }
    }
}
