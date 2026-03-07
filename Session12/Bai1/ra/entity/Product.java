package Session12.Bai1.ra.entity;

import java.util.Scanner;

public class Product {
    private static int autoId = 0;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    // Constructor không tham số
    public Product() {
        this.productId = ++autoId;
    }

    // Constructor đầy đủ
    public Product(String productName, float price, String category, int quantity) {
        this.productId = ++autoId;
        setProductName(productName);
        setPrice(price);
        setCategory(category);
        setQuantity(quantity);
    }

    // Getter
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public static int getAutoId() {
        return autoId;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter có điều kiện
    public void setProductName(String productName) {
        if (productName.length() >= 10 && productName.length() <= 50) {
            this.productName = productName;
        } else {
            System.out.println("Tên sản phẩm phải từ 10-50 ký tự!");
        }
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Giá phải lớn hơn 0!");
        }
    }

    public void setCategory(String category) {
        if (category.length() <= 200) {
            this.category = category;
        } else {
            System.out.println("Loại tối đa 200 ký tự!");
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng phải >= 0!");
        }
    }

    // inputData
    public void inputData(Scanner sc) {

        System.out.print("Nhập tên sản phẩm: ");
        setProductName(sc.nextLine());

        System.out.print("Nhập giá: ");
        setPrice(Float.parseFloat(sc.nextLine()));

        System.out.print("Nhập loại: ");
        setCategory(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        setQuantity(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                ", Name: " + productName +
                ", Price: " + price +
                ", Category: " + category +
                ", Quantity: " + quantity;
    }
}
