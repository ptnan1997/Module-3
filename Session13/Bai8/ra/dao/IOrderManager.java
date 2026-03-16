package Session13.Bai8.ra.dao;

import Session13.Bai8.ra.entity.Orders;

import java.util.List;

public interface IOrderManager {
    List<Orders> listAllOrders();
    Orders  getOrdersByCustomer(int customerId);
    void createOrder(Orders order);
}
