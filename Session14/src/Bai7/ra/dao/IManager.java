package Bai7.ra.dao;

import Bai7.ra.entity.Booking;
import Bai7.ra.entity.Room;

import java.util.Date;
import java.util.List;

public interface IManager {
    List<Room> listAvailableRooms();
    void bookRoom (Booking booking);
    void cancelBooking (int bookingId);

}
