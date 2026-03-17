package Bai5.presentation;

import Bai5.ra.dao.Manager;
import Bai5.ra.entity.Orders;

import java.math.BigDecimal;

public class Main05 {
    public static void main(String[] args) {
        Manager manager  = new Manager();
        BigDecimal totalAmount = new BigDecimal("1500.00");
        manager.placeOrder(new Orders(2,totalAmount,3,5));
    }
}
