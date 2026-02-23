package Session10.Bai5;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        InvoiceManager manager  = new InvoiceManager();
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
            choice = InputData5.getInt(sc,"Lựa chọn của bạn: ");
            switch (choice) {
                case 1 ->{
                    int invoiceId = InputData5.getInt(sc,"Nhập invoiceID: ");
                    double price = InputData5.getDouble(sc,"Nhập giá:");
                    Invoice invoice = new Invoice(invoiceId,price);
                    manager.add(invoice);
                    System.out.println("Hóa đơn đã được thêm thành công ✅");
                }
                case 2 ->{
                    manager.display();
                    int updateId = InputData5.getInt(sc,"Nhập id hóa đơn cần sửa");
                    int index = -1 ;
                    for (int i = 0 ; i < manager.invoices.size() ; i++) {
                        if(manager.invoices.get(i).getInvoiceID()==updateId) {
                            index = i;
                            break;
                        }
                    }
                    if(index == -1) {
                        System.out.println("Không tìm thấy hóa đơn cần sửa !");
                    } else {
                        double newPrice = InputData5.getDouble(sc,"Nhập vào giá mới: ");
                        manager.update(index,new Invoice(updateId,newPrice));
                        System.out.println("Hóa đơn đã được chỉnh sửa thành công");
                    }

                }
                case 3 ->{
                    manager.display();
                    int deleteId = InputData5.getInt(sc,"Nhập vào id hóa đơn bạn muốn xóa:");
                    int index = -1 ;
                    for (int i = 0 ; i < manager.invoices.size() ; i++) {
                        if(manager.invoices.get(i).getInvoiceID()==deleteId) {
                            index = i;
                            break;
                        }
                    }
                    if(index == -1) {
                        System.out.println("Không tìm thấy hóa đơn cần xóa !");
                    } else{
                        manager.delete(index);
                        System.out.println("Đã xóa thành công ✅");
                    }
                }
                case 4 ->
                    manager.display();

                case 5 ->{
                    System.out.println("Kết thúc chương trình !!!");
                    return;
                }
                default ->
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
