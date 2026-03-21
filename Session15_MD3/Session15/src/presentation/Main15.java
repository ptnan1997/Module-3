package presentation;

import ra.dao.ProductManager;
import ra.entity.Product;

import java.util.Scanner;

public class Main15 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        int choice;
        do {
            System.out.println("""
                    =========== PRODUCT MANAGEMENT ============
                    1. Danh sách sản phẩm
                    2. Thêm mới sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm
                    6. Sắp xếp sản phẩm theo giá tăng dần
                    7. Thống kê số lượng sản phẩm theo danh mục
                    8. Thoát
                    ===========================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->{ //Danh sách sản phẩm
                    manager.getAllProduct();
                }
                case 2 ->{ //Thêm mới sản phẩm
                    System.out.print("Nhập tên sản phẩm: ");
                    String productName =  sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    float productPrice = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập Tiêu đề sản phẩm: ");
                    String  productTitle = sc.nextLine();
                    System.out.print("Nhập Danh mục: ");
                    String   productCatalog = sc.nextLine();
                    manager.addProduct(new Product(productName,productPrice,productTitle,productCatalog));
                }
                case 3 ->{ //Cập nhật sản phẩm
                    System.out.print("Nhập ID sản phẩm cần cập nhật");
                    int productId =  Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên sản phẩm: ");
                    String productName =  sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    float productPrice = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập Tiêu đề sản phẩm: ");
                    String  productTitle = sc.nextLine();
                    System.out.print("Nhập Danh mục: ");
                    String   productCatalog = sc.nextLine();
                    manager.updateProduct(productId , new Product(productName,productPrice,productTitle,productCatalog));
                }
                case 4 ->{ //Xóa sản phẩm
                    System.out.print("Nhập productId cần xóa: ");
                    int productId =  Integer.parseInt(sc.nextLine());
                    manager.deleteProduct(productId);
                }
                case 5 ->{ //Tìm kiếm sản phẩm theo tên sản phẩm
                    System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
                    String productName =   sc.nextLine();
                    manager.findProductByName(productName);
                }
                case 6 -> //Sắp xếp sản phẩm theo giá tăng dần
                    manager.orderByPriceIncrease();

                case 7 ->{ //Thống kê số lượng sản phẩm theo danh mục
                    System.out.print("Nhập danh mục muốn thống kê số lượng sản phẩm: ");
                    String productCatalog = sc.nextLine();
                    manager.countProductByCatalog(productCatalog);
                }
                case 8 -> System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng");
            }
        } while(choice != 8);
    }
}
