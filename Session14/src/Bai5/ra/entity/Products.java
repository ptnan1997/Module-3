package Bai5.ra.entity;

public class Products {
    private int productId;
    private String producName;
    private int stock;

    // Constructor không tham số

    public Products() {
    }
    // Constructor có tham số
    public Products(String producName, int stock) {
        this.producName = producName;
        this.stock = stock;
    }
    // Getter and setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", producName='" + producName + '\'' +
                ", stock=" + stock +
                '}';
    }
}
