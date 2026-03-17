package Bai5.ra.dao;

import Bai1.JDBC.database01;
import Bai5.ra.entity.Orders;
import Bai5.ra.entity.Products;

import java.math.BigDecimal;
import java.sql.*;

public class Manager {
    public void placeOrder(Orders order){
        // Mở kết nối
        try (Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement getProduct = con.prepareCall("{call get_product_by_id(?)}");
            getProduct.setInt(1, order.getProductId());
            ResultSet result = getProduct.executeQuery();
            int stock = 0;
            if (result.next()){
                stock = result.getInt("stock");
            } else{
                System.out.println("Sản phẩm không tồn tại");
                return;
            }
            // Kiểm tra tồn kho
            if (stock< order.getQuantity()){
                System.out.println("Không đủ hàng trong kho");
                con.rollback();
                return;
            }
            // Thêm đơn đặt hàng
            CallableStatement placeOrder = con.prepareCall("{call place_order(?,?,?,?)}");
            placeOrder.setInt(1, order.getCustomerId());
            placeOrder.setBigDecimal(2,order.getTotalAmount() );
            placeOrder.setInt(3, order.getProductId());
            placeOrder.setInt(4, order.getQuantity());

             placeOrder.executeUpdate();
            int newStock = stock - order.getQuantity();

            CallableStatement updateStock = con.prepareCall("{call save_Stock_Product(?,?)}");
            updateStock.setInt(1, order.getProductId());
            updateStock.setInt(2, newStock);

            updateStock.executeUpdate();
            System.out.println("Order placed successfully");
            con.commit();

        } catch (SQLException e){
            System.out.println("Lỗi đặt hàng");
            e.printStackTrace();
        }
    }
}
