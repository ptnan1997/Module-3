package Bai4.ra.dao;

import Bai1.JDBC.database01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountManager {
    public void tranferFunds (int fromAccountId,  int toAccountId, double amount) {
        // Mở kết nối
        try (Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall("{call transfer_funds(?, ?, ?)}");
            call.setInt(1, fromAccountId);
            call.setInt(2, toAccountId);
            call.setDouble(3, amount);
            int rs  = call.executeUpdate();
            if(rs == 0){
                System.out.println("Transfer failed");
                con.rollback();
            }
            con.commit();
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
