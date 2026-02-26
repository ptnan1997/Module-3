package Session11.Bai6;

import java.util.Arrays;
import java.util.List;

import static Session11.Bai6.InterfaceProductProcesser.printProductList;

public class Main06 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Nồi cơm điện",230),
                new Product ("Giầy thể thao nam",200),
                new Product ("Gấu bông",100),
                new Product ("Ốp lưng điện thoại ip",90),
                new Product ("Chìa khóa vạn năng",40),
                new Product ("Áo thun nam",200),
                new Product ("Bình giữ nhiệt",300),
                new Product ("Đèn bàn học",150));
        ProductProcesserImpl ppi  = new ProductProcesserImpl();

        boolean check = ppi.hasExpensiveProduct(products);
        if (check) {
            for (Product product : products) {
                if (product.getPrice()>100){
                    product.display();
                }
            }
        }else {
            System.out.println("Không có sản phẩm đắt tiền");
        }
        // Tính tổng giá trị của tất cả sản phẩm
        double sumTotalValue = ppi.calculatTotalValue(products);
        // In danh sách các sản phẩm bằng phương thức printProductList
        printProductList(products);  
    }
}
