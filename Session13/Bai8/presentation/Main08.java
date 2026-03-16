package Session13.Bai8.presentation;

import Session13.Bai8.ra.dao.CustomerManager;
import Session13.Bai8.ra.dao.InputData13_8;
import Session13.Bai8.ra.dao.OrderManager;
import Session13.Bai8.ra.dao.ProductManager;
import Session13.Bai8.ra.entity.Customer;
import Session13.Bai8.ra.entity.Orders;
import Session13.Bai8.ra.entity.Product;

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerManager customerManager  = new CustomerManager();
        ProductManager productManager  = new ProductManager();
        OrderManager orderManager  = new OrderManager();
        int choice;
        do {
            System.out.println("""
                    =============== QUẢN LÝ ĐƠN HÀNG ============
                    1. Thêm sản phẩm mới
                    2. Cập nhật thông tin khách hàng
                    3. Tạo đơn hàng mới
                    4. Hiển thị danh sách đơn hàng
                    5. Tìm kiếm đơn hàng theo khách hàng
                    6, Thoát chương trình
                    =============================================
                    """);
            choice = InputData13_8.getInt(sc,"Lựa chọn của bạn: ");
            switch (choice) {
                case 1 ->{ // Thêm sản phẩm mới
                    String productName = InputData13_8.getString(sc,"Nhập vào tên sản phẩm: ");
                    double productPrice = InputData13_8.getDouble(sc,"Nhập vào giá sản phẩm ");
                    productManager.addProduct(new Product(productName,productPrice));
                }
                case 2 ->{ // Cập nhật thông tin khách hàng
                    int customerIdEdit = InputData13_8.getInt(sc,"Nhập id khách hàng bạn muốn cập nhật: ");
                    String customerName = InputData13_8.getString(sc,"Cập nhật tên khách hàng: ");
                    String customerEmail = InputData13_8.getString(sc,"Cập nhật email khách hàng: ");
                    customerManager.updateCustomer(customerIdEdit,new Customer(customerName,customerEmail));
                }
                case 3 ->{ // Tạo đơn hàng mới
                    int customerID = InputData13_8.getInt(sc,"ID của khách hàng muốn tạo đơn: ");
                    orderManager.createOrder(new Orders(customerID));
                }
                case 4 -> // Hiển thị danh sách đơn hàng
                    orderManager.listAllOrders();

                case 5 ->{ // Tìm kiếm đơn hàng theo khách hàng
                    int customerId = InputData13_8.getInt(sc,"Nhập id khách hàng muốn tìm kiếm: ");
                    orderManager.getOrdersByCustomer(customerId);
                }
                case 6 -> // Thoát
                    System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng ");

                default -> System.out.println("Lựa chọn không hợp lệ.Vui lòng nhập lại");

            }
        } while (choice != 6);
    }
}
