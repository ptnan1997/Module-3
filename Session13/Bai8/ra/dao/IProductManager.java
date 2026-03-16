package Session13.Bai8.ra.dao;

import Session13.Bai8.ra.entity.Product;

import java.sql.SQLException;

public interface IProductManager {
    void  addProduct(Product product) throws SQLException;
}
