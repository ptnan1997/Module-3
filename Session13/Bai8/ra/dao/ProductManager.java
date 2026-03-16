package Session13.Bai8.ra.dao;

import Session13.Bai8.JDBC.database_bai8;
import Session13.Bai8.ra.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements  IProductManager {
    List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        // Mở kết nối
        try (Connection con = database_bai8.openConnection()) {
            String checkSql = "SELECT * FROM Product WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(checkSql);
            ps.setString(1, product.getProduct_name());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Sản phẩm đã tồn tại!");
                return;
            }
            CallableStatement call = con.prepareCall("{call add_product(?,?)}");
            call.setString(1, product.getProduct_name());
            call.setDouble(2, product.getProduct_price());
            call.executeUpdate();
            System.out.println("Đã thêm sản phẩm thành công ✅");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
