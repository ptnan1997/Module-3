package Session11.Bai6;

public class Product {
    private String productName;
    private double price;
    public Product(){}
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
    public void display(){
        System.out.printf("Product Name: %s | Price: %.2f\n", productName, price);
    }
}
