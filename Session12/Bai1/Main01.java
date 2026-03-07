package Session12.Bai1;

import Session12.Bai1.ra.business.ProductBusiness;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductBusiness pb = new ProductBusiness();

        while (true) {
            System.out.println("""
                    ===== QUẢN LÝ SẢN PHẨM =====
                    1. Thêm sản phẩm
                    2. Hiển thị danh sách
                    3. Cập nhật theo mã
                    4. Xóa theo mã
                    5. Tìm theo tên
                    6. Sắp xếp theo giá tăng dần
                    7. Sắp xếp theo số lượng giảm dần
                    0. Thoát
                    ============================
                    """);
            System.out.print("Chọn: ");
            String choiceStr = sc.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1 -> pb.addProduct();
                case 2 -> pb.displayProduct();
                case 3 -> {
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    int id = Integer.parseInt(sc.nextLine());
                    pb.updateProduct(id);
                }
                case 4 -> {
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    pb.deleteProduct(id);
                }
                case 5 -> {
                    System.out.print("Nhập từ khóa tên: ");
                    String key = sc.nextLine();
                    pb.findProductByName(key);
                }
                case 6 -> pb.sortByPriceAsc();
                case 7 -> pb.sortByQuantityDesc();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}