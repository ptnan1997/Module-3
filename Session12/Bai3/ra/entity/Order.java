package Session12.Bai3.ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private static  int autoId = 0;
    private int orderId; // Số nguyên tự tăng
    private String customerName; // Chuỗi gồm 6 - 100 ký tự
    private String phoneNumber; // chuỗi  bắt buộc nhập định dạng số điện thoại việt nam
    private String address; // chuỗi  bắt buộc nhập
    private float orderAmount; // giá trị lớn hơn 0
    public enum Status {PENDING,
        SHIPPED,
        DELIVERED}
    private Status status;
    //Constructor không tham số
    public Order (){
        this.orderId = ++autoId;
        this.status =  Status.PENDING;
    }
    // Constructor
    public Order(String customerName, String phoneNumber,
                 String address, float orderAmount, Status status) {
        this.orderId = ++autoId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // Getter & Setter

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", orderAmount=" + orderAmount +
                ", status=" + status +
                '}';
    }
    // ----- Regex Patterns------
    // Tên: 6-100 ký tự, không cho toàn khoảng trắng
    private static final Pattern NAME_PATTERN =
            Pattern.compile("^(?!\\s*$).{6,100}$");

    // Địa chỉ: ít nhất 1 ký tự không phải khoảng trắng
    private static final Pattern ADDRESS_PATTERN =
            Pattern.compile("^(?!\\s*$).+$");

    // SĐT di động VN (phổ biến): 0 + (3|5|7|8|9) + 8 chữ số
    // Ví dụ: 0901234567, 0391234567, 0581234567...
    private static final Pattern VN_MOBILE_PATTERN =
            Pattern.compile("^0[35789]\\d{8}$");

    // Số thực dương (cho phép dạng 10, 10.5, 0.5)
    private static final Pattern POSITIVE_FLOAT_PATTERN =
            Pattern.compile("^(?:0*\\.[0-9]+|[1-9]\\d*(?:\\.[0-9]+)?)$");
    public void inputData(Scanner scanner) {
        // customerName
        while (true){
            System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
            String input = scanner.nextLine().trim();
            if (NAME_PATTERN.matcher(input).matches()){
                this.customerName  = input;
                break;
            }
            System.out.println("❌ Tên không hợp lệ! (phải 6-100 ký tự, không được để trống)");
        }
        // phoneNumber
        while  (true){
            System.out.print("Nhập số điện thoại di động VN (vd: 0901234567): ");
            String input = scanner.nextLine().trim();
            if (VN_MOBILE_PATTERN.matcher(input).matches()) {
                this.phoneNumber = input;
                break;
            }
            System.out.println("❌ SĐT không hợp lệ! Định dạng đúng: 0 + (3/5/7/8/9) + 8 chữ số.");
        }
        // address
        while (true){
            System.out.println("Nhập địa chỉ giao hàng");
            String input = scanner.nextLine().trim();
            if (ADDRESS_PATTERN.matcher(input).matches()){
                this.address = input;
                break;
            }
            System.out.println("❌ Địa chỉ không được để trống!");
        }
        // orderAmount
        while (true) {
            System.out.print("Nhập giá trị đơn hàng (float > 0): ");
            String input = scanner.nextLine().trim();

            // validate bằng regex trước
            if (!POSITIVE_FLOAT_PATTERN.matcher(input).matches()) {
                System.out.println("❌ Giá trị không hợp lệ! Ví dụ đúng: 100, 99.5, 0.5");
                continue;
            }

            // parse và check > 0 (phòng trường hợp cực trị)
            try {
                float value = Float.parseFloat(input);
                if (value > 0) {
                    this.orderAmount = value;
                    break;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("❌ Giá trị phải là số thực > 0!");
        }
        // status
        while (true) {
            System.out.print("Nhập trạng thái (1.Pending | 2.Shipped | 3.Delivered): ");
            String input = scanner.nextLine().trim();
            if (input.matches("[1-3]")) {
                int choice = Integer.parseInt(input);
                this.status = switch (choice) {
                    case 1 -> Status.SHIPPED;
                    case 2 -> Status.DELIVERED;
                    default -> Status.PENDING;
                };
                break;
            }
            System.out.println("❌ Chỉ được nhập 1, 2 hoặc 3!");
        }
    }
}
