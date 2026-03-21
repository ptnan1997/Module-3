package ra.dao;

import JDBC.Connector;
import ra.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        // Mở kết nối
        try (Connection con = Connector.openConnection()){
            assert con != null;
            CallableStatement call =  con.prepareCall("{call getAllProductsInfo()}");
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Product product = new Product(
                        rs.getString("product_name"),
                        rs.getFloat("product_price"),
                        rs.getString("product_Title"),
                        rs.getString("product_catalog")
                );
                product.setProductCreated(rs.getDate("product_created"));
                product.setStatus(rs.getBoolean("product_status"));
                product.setProductId(rs.getInt("product_id"));
                products.add(product);
            }
            if(products.isEmpty()){
                System.out.println("No products found");
            } else {
                for (Product p : products){
                    System.out.println(p);
                }
            }
        } catch (SQLException e ){
            throw  new RuntimeException(e);
        }
        return  products;
    }
    public boolean checkCatalogExistorNot(){
        //Mở kết nối
        try (Connection con = Connector.openConnection()){
            assert con != null;
            CallableStatement call  =  con.prepareCall("{call CheckCatalogExistorNot(?)}");
            boolean check_exist = call.execute();
            if (!check_exist){
                System.out.println("Catalog does not exist");
            }
            return check_exist;
        } catch  (SQLException e ){
            throw  new RuntimeException(e);
        }
    }
    public void addProduct (Product product){
        // Mở kết nối
        try(Connection con = Connector.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall("{call addNewProduct(?,?,?,?)}");
            call.setString(1, product.getProductName());
            call.setFloat(2, product.getProductPrice());
            call.setString(3, product.getProductTitle());
            call.setString (4,product.getProductCatalog());
            int rs = call.executeUpdate();
            if (rs != 0){
                System.out.println("Product added successfully");
                con.commit();
            } else {
                System.out.println("Unable to add product");
                con.rollback();
            }
        } catch( NullPointerException | SQLException  e){
            throw  new RuntimeException(e);
        }
    }
    public void updateProduct(int productId , Product product){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            call  = conn.prepareCall("{call updateProductById(?,?,?,?,?,?)}");
            call.setInt(1, productId);
            call.setString(2, product.getProductName());
            call.setFloat(3, product.getProductPrice());
            call.setString(4, product.getProductTitle());
            call.setString(5, String.valueOf(product.getProductCreated()));
            call.setString( 6, product.getProductCatalog());
            int rs = call.executeUpdate();
            if (rs == 0){
                System.out.println("Unable to update product");
                conn.rollback();
            } else {
                System.out.println("Updated product");
                conn.commit();
            }
        } catch (SQLException | NullPointerException e){
            throw  new RuntimeException(e);
        } finally {
            Connector.closeConnection(conn);
        }
    }
    public void deleteProduct (int productId){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            conn.setAutoCommit(false);
            call  = conn.prepareCall("{call deleteProductFromId(?)}");
            call.setInt(1, productId);
            int up = call.executeUpdate();
            if (up != 0){
                System.out.println("Deleted product");
                conn.commit();
            } else {
                System.out.println("Unable to delete product");
                conn.rollback();
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally{
            Connector.closeConnection(conn);
        }
    }
    public void getProductFromId (int productId){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            call = conn.prepareCall("{call getProductInfo(?)}");
            call.setInt(1, productId);
            ResultSet rs = call.executeQuery();
            List<Product>  products = new ArrayList<>();
            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_Title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                products.add(product);
            }
            for (Product p : products){
                System.out.println(p);
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally {
            Connector.closeConnection(conn);
        }
    }
    public void findProductByName (String productName){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            call = conn.prepareCall("{call getProductByName(?)}");
            call.setString(1, productName);
            ResultSet rs = call.executeQuery();
            List<Product>  products = new ArrayList<>();
            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_Title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                products.add(product);
            }
            for (Product p : products){
                System.out.println(p);
            }
        } catch (SQLException e ){
            throw  new RuntimeException(e);
        } finally {
            Connector.closeConnection(conn);
        }
    }
    public void countProductByCatalog(String  product_catalog){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            call = conn.prepareCall("{call stalisticProductBy(?,?)}");
            call.setString(1, product_catalog);
            call.registerOutParameter(2, Types.INTEGER);
            call.execute();
            int count = call.getInt(2);
            System.out.println("Count of product by catalog: " + count);
        } catch(SQLException e){
            throw  new RuntimeException(e);
        } finally {
            Connector.closeConnection(conn);
        }
    }
    public void orderByPriceIncrease(){
        Connection conn = null;
        CallableStatement call;
        try {
            conn = Connector.openConnection();
            call =  conn.prepareCall("{call orderByPriceIncrease()}");
            ResultSet  rs = call.executeQuery();
            List<Product>  products = new ArrayList<>();
            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_Title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                products.add(product);
            }
            for (Product p : products){
                System.out.println(p);
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        } finally {
            Connector.closeConnection(conn);
        }
    }
}
