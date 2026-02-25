package Session11.Bai4;

public class Product {
    private int  productID;
    private String productName;
    private double price;

    // Constructor không tham số
    public Product(){

    }
    // Constructor có tham số
    public Product(int productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }
    // Getter and Setter

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void display(){
        System.out.printf("ProductID: %d | ProductName: %s | Price: %.2f\n", productID, productName, price);
    }
    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
