package Bai7.ra.dao;

import Bai1.JDBC.database01;
import Bai7.ra.entity.Booking;
import Bai7.ra.entity.Room;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelManager implements IManager{

    @Override
    public List<Room> listAvailableRooms() {
        List <Room> rooms = new ArrayList<>();
        // Mở kết nối
        try (Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call =  con.prepareCall("{call listAvailableRooms()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Room room = new Room(
                        rs.getString("room_number"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getBoolean("is_booked")
                );
                room.setRoomID(rs.getInt("room_id"));
                rooms.add(room);
            }
            if (rooms.isEmpty()){
                System.out.println("No available rooms");
                con.rollback();
            } else {
                for (Room room : rooms){
                    System.out.println(room);
                }
                con.commit();
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return   rooms;
    }

    @Override
    public void bookRoom(Booking booking) {
        // Mở kết nối
        try (Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall("{call bookRoom(?,?,?,?)}");
            call.setInt(1, booking.getRoomId());
            call.setString(2, booking.getCustomerName());
            call.setDate(3,booking.getStartDate() );
            call.setDate(4,booking.getEndDate() );
            int rs = call.executeUpdate();
            if (rs == 0){
                System.out.println("Can not book room");
                con.rollback();
            } else {
                System.out.println("Room booked successfully");
                con.commit();
            }
        }catch (SQLException e){
            System.out.println("Lỗi định dạng nhập thông tin");
        }
    }


    @Override
    public void cancelBooking(int bookingId) {
        try (Connection con = database01.openConnection()){
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall("{call cancelBooking(?)}");
            call.setInt(1, bookingId);
            int rs = call.executeUpdate();
            if (rs == 0){
                System.out.println("Can not cancel room");
                con.rollback();
            } else {
                System.out.println("Booking cancelled successfully");
                con.commit();
            }
        } catch (SQLException e){
            System.out.println("Can Not Found BookingID");
        }
    }
}
