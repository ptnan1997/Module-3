package Session13.Bai8.ra.entity;

import java.sql.Date;
import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Orders {
    private int  orderId;
    private int customerId;
    private Date orderDate;
    private double totalAmount;
    public Orders(){
        this.orderDate = Date.valueOf(LocalDate.now());
        this.totalAmount = 0;
    }
    public Orders( int customerId) {
        this.customerId = customerId;

    }

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
