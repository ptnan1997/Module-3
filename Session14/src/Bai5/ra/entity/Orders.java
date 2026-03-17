package Bai5.ra.entity;

import java.math.BigDecimal;

public class Orders {
    private int orderId;
    private int customerId;
    private BigDecimal totalAmount;
    private int productId;
    private int quantity;
    // Constructor không tham số

    public Orders() {
    }

    // Constructor có tham số
    public Orders( int customerId, BigDecimal totalAmount, int productId, int quantity) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.productId = productId;
        this.quantity = quantity;
    }
    // Getter and setter

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", totalAmount=" + totalAmount +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
