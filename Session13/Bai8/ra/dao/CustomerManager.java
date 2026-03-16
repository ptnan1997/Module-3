package Session13.Bai8.ra.dao;

import Session13.Bai8.JDBC.database_bai8;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Session13.Bai8.ra.entity.Customer;
public class CustomerManager implements ICustomerManager{
    List <Customer> customers =new ArrayList<>();
    @Override
    public void updateCustomer(int customerId, Customer  customer) {
        // Mở kết nối
        try (Connection conn = database_bai8.openConnection()){
            CallableStatement call = conn.prepareCall("{call update_Customer(?,?,?)}");
            call.setInt(1, customerId);
            call.setString(2,customer.getCustomerName());
            call.setString(3,customer.getCustomerEmail());
            for (Customer c : customers) {
                if (c.getCustomer_id() == customerId) {
                    call.executeUpdate();
                    call.close();
                } else {
                    System.out.println("Customer is not found");
                }
            }
        } catch (SQLException e){
            throw new  RuntimeException(e);
        }
    }
}
