package Session12.Bai3.ra.business;

import Session12.Bai3.ra.entity.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderBusiness {
    Scanner sc = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>();

    //    private Order findById(int id) {
//        for (Order o : orderList) {
//            if (o.getOrderId() == id) {
//                return o;
//            }
//        }
//        return null;
//    }
    // Thêm đơn hàng
    public void addOrder() {
        Order order = new Order();
        order.inputData(sc);
        orderList.add(order);
        System.out.println("Thêm đơn hàng thành công ✅");
    }

    // Hiển thị danh sách đơn hàng sắp xếp theo giá trị đơn hàng giảm dần
    public void displayOrdersDescByAmoutn() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng! ");
            return;
        }
        orderList.sort(Comparator.comparing(Order::getOrderAmount).reversed());
        for (Order order : orderList) {
            System.out.println(orderList.toString());
        }
    }

    // Cập nhật trạng thái đơn hàng (Chỉ cho phép chuyển từ Pending Shipped Delivered)
    public void updateStatusByID(Integer OrderID,Scanner sc) {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng! ");
            return;
        }
        for (Order o : orderList) {
            if (o.getOrderId() == OrderID) {
                System.out.println("Trạng thái hiện tại: " + o.getStatus());
                if (o.getStatus() == Order.Status.DELIVERED) {
                    System.out.println("Đơn hàng đã DELIVERED, không thể cập nhật!");
                    return;
                }
             // Xác định trạng thái kế tiếp
             Order.Status nextStatus =(o.getStatus()==Order.Status.PENDING) ? Order.Status.SHIPPED : Order.Status.DELIVERED;
                System.out.println("Nếu cập nhật sẽ chuyển thành: " + nextStatus);

                System.out.print("Bạn có muốn cập nhật không? (y/n): ");
                String confirm = sc.nextLine().trim();

                if (!confirm.equalsIgnoreCase("Y")) {
                    System.out.println("Đã hủy cập nhật.");
                    return;
                }

                o.setStatus(nextStatus);
                System.out.println("Cập nhật thành công! Trạng thái mới: " + o.getStatus());
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng");
    }
    // Xóa đơn hàng theo mã đơn hàng
    public void deleteByID (Integer OrderID) {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách rỗng !");
            return;
        }
        for (int i = 0; i < orderList.size(); i++) {
            Order o  = orderList.get(i);

            if (o.getOrderId() == OrderID) {
                if (o.getStatus() == Order.Status.PENDING) {
                    orderList.remove(o);
                    System.out.println("Đã xóa đơn hàng thành công ✅");
                    return;
                }
                System.out.println("Không thể xóa khi trạng thái đơn hàng không phải là Pending");
            }
        }
        System.out.println("Không tìm thấy đơn hàng");
    }
    // Tìm kiếm đơn hàng theo tên khách hàng
    public void findOrderByCustomerName(String name){
        boolean found = false;
        for  (Order o : orderList) {
            if (o.getCustomerName().equalsIgnoreCase(name)) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đơn hàng theo tên khách hàng!");
        }
    }
    // Thống kê tổng số đơn hàng
    public void StatisticTotalOrders(){
        System.out.println("Tổng số đơn hàng là: " + orderList.size());
    }
    // Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered
    public void calculateDeliveredRevenue(){
        float sum = 0;
        for   (Order o : orderList) {
            if (o.getStatus() == Order.Status.DELIVERED) {
                sum += o.getOrderAmount();
            }
        }
        System.out.println("Tổng doanh thu các đơn DELIVERED: " + sum);
    }
    // Thống kê số lượng đơn hàng theo từng trạng thái
    public void calAmountOfOrders(Order.Status status){
        int count = 0;
        for   (Order o : orderList) {
            if(o.getStatus() == status) {
                count++;
            }
        }
        System.out.printf("Số lượng đơn hàng theo trạng thái %s: %d", status, count);
    }
    // Tím kiếm đơn hàng có giá trị lớn nhất
    public void findMostValueOfOrders(){
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng!");
            return;
        }

        float max = orderList.getFirst().getOrderAmount();
        for (Order order : orderList) {
            if (order.getOrderAmount() > max) {
                max = order.getOrderAmount();
            }
        }
        for  (Order o : orderList) {
            if (o.getOrderAmount() == max) {
                System.out.println("Đơn hàng có giá trị lớn nhất: "+o);
            }
        }
    }

}