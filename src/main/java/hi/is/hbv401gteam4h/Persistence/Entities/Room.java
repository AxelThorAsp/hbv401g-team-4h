package hi.is.hbv401gteam4h.Persistence.Entities;

import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;

import java.util.Date;
import java.util.List;

public class Room {

    private int roomNum;
    private RoomEnum type;
    private int bedCount;
    private List<Booking> bookingList;



    public Room(int roomNum, RoomEnum type, int bedCount) {
        this.roomNum = roomNum;
        this.type = type;
        this.bedCount = bedCount;
    }

    public boolean isAvailableFromTo(Date dateFrom, Date dateTo) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum=" + roomNum +
                ", type=" + type +
                ", bedCount=" + bedCount +
                ", bookingList=" + bookingList +
                '}';
    }
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public RoomEnum getType() {
        return type;
    }

    public void setType(RoomEnum type) {
        this.type = type;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
