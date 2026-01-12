package Session3;
import  java.util.Scanner;
public class Session3_Bai1 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        System.out.print("Khách hàng tên gì vậy ạ (^.^):");
        String customerName = sc.nextLine();
        System.out.print("Khách hàng muốn mua sản phẩm gì ạ <3:");
        String productName =  sc.nextLine();
        System.out.print(" Cho bé biết giá sản phẩm với ạ (^.^):");
        double price  = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng bao nhiêu nè <3.<3:");
        int quantity =  Integer.parseInt(sc.nextLine());
        System.out.print("Anh/Chị có thẻ thành viên không ạ(true/false):");
        boolean isMember =  sc.nextBoolean();
        double amount = price * quantity;
        double discount = 0;
        if (isMember){
            discount = amount*0.1;
        }
        double isVAT = amount *0.08;
        double totalAmount = amount - discount + isVAT;

        System.out.printf
                ("""
                                Khách hàng: %s
                                Sản phẩm: %s
                                Giá: %f
                                Số lượng: %d
                                Thành tiền: %f
                                Giảm giá: %f
                                Tiền VAT: %f
                                Tổng tiền thanh toán: %f
                                """,
                        customerName,
                        productName,
                        price,
                        quantity,
                        amount,
                        discount,
                        isVAT,
                        totalAmount
                        );
    }
}
