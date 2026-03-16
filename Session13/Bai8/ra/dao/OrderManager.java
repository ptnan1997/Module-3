package Session13.Bai8.ra.dao;

import Session13.Bai8.JDBC.database_bai8;
import Session13.Bai8.ra.entity.Orders;
import Session13.Bai8.ra.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager implements  IOrderManager {

    @Override
    public List<Orders> listAllOrders() {
        List <Orders> listOrders = new ArrayList<>();
        // Mở kết nối
        try (Connection conn = database_bai8.openConnection()){
            CallableStatement call =  conn.prepareCall("{call listAllOrders()}");
            call.executeQuery();
            ResultSet rs = call.getResultSet();
            while (rs.next()){
                Orders order = new Orders(
                        rs.getInt("customer_id")
                );
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                listOrders.add(order);
            }
            for (Orders order : listOrders){
                System.out.println(order);
                database_bai8.closeConnection(conn);
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return  listOrders;
    }

    @Override
    public Orders getOrdersByCustomer(int customerId) {
        List  <Orders> listOrders = new ArrayList<>();
        // Mở kết nối
        try (Connection con = database_bai8.openConnection()){
            CallableStatement call = con.prepareCall("{call getOrdersByCustomer(?)}");
            call.setInt(1, customerId);
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Orders order = new Orders(
                        rs.getInt("customer_id")
                );
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                listOrders.add(order);
            }
            for (Orders order : listOrders){
                System.out.println(order);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public void createOrder(Orders order) {
        // Mở kết nối
        try (Connection con = database_bai8.openConnection()){
            Scanner sc  = new Scanner(System.in);
            String getPrice = "SELECT price from Product where id= ?";
            String listProduct = "SELECT * FROM Product";
            double totalAmount=0;
            boolean isBuying = true;
            while (isBuying){
                List <Product> listProducts = new ArrayList<>();
                PreparedStatement printListProduct =  con.prepareStatement(listProduct);
                ResultSet  rs1 = printListProduct.executeQuery();
                while (rs1.next()){
                    Product printlistProduct  = new Product(
                            rs1.getString("name"),
                            rs1.getDouble("price")
                    );
                    printlistProduct.setProduct_id(rs1.getInt("id"));
                    listProducts.add(printlistProduct);
                }
                for  (Product product : listProducts){
                    System.out.println(product);
                }
                int productId = InputData13_8.getInt(sc,"Nhập vào id sản phẩm mà bạn muốn chọn: ");
                // Lấy giá sản phẩm
                PreparedStatement psPrice = con.prepareStatement(getPrice);
                psPrice.setInt(1, productId);
                ResultSet rs = psPrice.executeQuery();
                if (!rs.next()){
                    System.out.println("Product not found !");
                    continue;
                }
                double  price = rs.getDouble("price");
                int  quantity = InputData13_8.getInt(sc,"Nhập số lượng mua: ");
                totalAmount = (price * quantity)+totalAmount;
                System.out.print("Bạn có muốn tiếp tục mua hàng không? (Nhập 1 - Có , 0 - Không): ");
                int isContinued = sc.nextInt();
                if (isContinued != 1){
                    isBuying = false;
                }
            }
            CallableStatement call = con.prepareCall("{call create_Order(?,?)}");

            call.setInt(1, order.getCustomerId());
            call.setDouble(2, totalAmount);
            call.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
