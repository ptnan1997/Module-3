package Session12.Bai1.ra.business;

import Session12.Bai1.ra.entity.Product;
import Session12.Bai1.utils.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    private final Scanner sc = new Scanner(System.in);
    private final List<Product> productList = new ArrayList<>();

    // ===== Helper: check trùng tên (không phân biệt hoa thường) =====
    private boolean isDuplicateName(String name) {
        for (Product p : productList) {
            if (p.getProductName() != null && p.getProductName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // ===== Helper: tìm index theo id =====
    private int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) return i;
        }
        return -1;
    }

    // Thêm sản phẩm
    public void addProduct() {
        Product p = new Product();

        // name: 10-50 + không trùng
        while (true) {
            String productName = Validate.inputStringLength(sc, "Nhập tên sản phẩm: ", 10, 50);
            if (isDuplicateName(productName)) {
                System.out.println("Tên sản phẩm đã tồn tại!");
                continue;
            }
            p.setProductName(productName);
            break;
        }

        float price = Validate.inputPositiveFloat(sc, "Nhập giá: ");
        String category = Validate.inputStringMax(sc, "Nhập danh mục: ", 200);
        int quantity = Validate.inputNonNegativeInt(sc, "Nhập số lượng: ");

        p.setPrice(price);
        p.setCategory(category);
        p.setQuantity(quantity);

        productList.add(p);
        System.out.println("Thêm sản phẩm thành công ✅");
    }

    // Hiển thị danh sách sản phẩm
    public void displayProduct() {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // Cập nhật sản phẩm theo mã sản phẩm
    public void updateProduct(int product_id) {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        int index = findIndexById(product_id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + product_id);
            return;
        }

        Product product = productList.get(index);

        // name: 10-50 + không trùng (trừ chính nó)
        while (true) {
            String newName = Validate.inputStringLength(sc, "Nhập tên sản phẩm mới: ", 10, 50);

            boolean dup = false;
            for (Product p : productList) {
                if (p.getProductId() != product_id
                        && p.getProductName() != null
                        && p.getProductName().equalsIgnoreCase(newName)) {
                    dup = true;
                    break;
                }
            }

            if (dup) {
                System.out.println("Tên sản phẩm đã tồn tại!");
                continue;
            }

            product.setProductName(newName);
            break;
        }

        float newPrice = Validate.inputPositiveFloat(sc, "Nhập giá mới: ");
        String newCategory = Validate.inputStringMax(sc, "Nhập danh mục mới: ", 200);
        int newQuantity = Validate.inputNonNegativeInt(sc, "Nhập số lượng mới: ");

        product.setPrice(newPrice);
        product.setCategory(newCategory);
        product.setQuantity(newQuantity);

        System.out.println("Cập nhật thành công ✅");
    }

    // Xóa sản phẩm theo mã sản phẩm (SỬA lỗi remove trong for-each)
    public void deleteProduct(int product_id) {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        int index = findIndexById(product_id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + product_id);
            return;
        }

        productList.remove(index);
        System.out.println("Xóa thành công ✅");
    }

    // Tìm kiếm sản phẩm theo tên (gần đúng + không phân biệt hoa thường)
    public void findProductByName(String keyword) {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        String key = keyword.trim().toLowerCase();
        boolean found = false;

        for (Product p : productList) {
            String name = (p.getProductName() == null) ? "" : p.getProductName().toLowerCase();
            if (name.contains(key)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm phù hợp!");
        }
    }

    // Sắp xếp sản phẩm theo giá tăng dần
    public void sortByPriceAsc() {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }
        productList.sort((a, b) -> Float.compare(a.getPrice(), b.getPrice()));
        System.out.println("Đã sắp xếp theo giá tăng dần ✅");
    }

    // Sắp xếp sản phẩm theo số lượng giảm dần
    public void sortByQuantityDesc() {
        if (productList.isEmpty()) {
            System.out.println("No products found");
            return;
        }
        productList.sort((a, b) -> Integer.compare(b.getQuantity(), a.getQuantity()));
        System.out.println("Đã sắp xếp theo số lượng giảm dần ✅");
    }
}