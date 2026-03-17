package Bai7.ra.entity;

import java.math.BigDecimal;

public class Room {
    private int  roomID;
    private String roomNumber;
    private String type;
    private BigDecimal price;
    private boolean isBooked;

    public Room() {
    }

    public Room( String roomNumber, String type, BigDecimal price, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = isBooked;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isBooked=" + isBooked +
                '}';
    }
}
