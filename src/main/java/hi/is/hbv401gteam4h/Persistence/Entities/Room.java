package hi.is.hbv401gteam4h.Persistence.Entities;

import hi.is.hbv401gteam4h.Service.BookingService;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;

import java.util.Date;

import static hi.is.hbv401gteam4h.util.Util.between;

public class Room {

    private int roomId;
    private RoomEnum type;
    private int bedCount;


    public Room(int roomId, RoomEnum type, int bedCount) {
        this.roomId = roomId;
        this.type = type;
        this.bedCount = bedCount;
    }

    public boolean isAvailableFromTo(Date dateFrom, Date dateTo) {
        for (Booking b: BookingService.getAllBookings(this)) {
            if (between(b.getDateFrom(), dateFrom, dateTo) || between(b.getDateTo(), dateFrom, dateTo))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum=" + roomId +
                ", type=" + type +
                ", bedCount=" + bedCount +
                '}';
    }
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

}
