package hi.is.hbv401gteam4h.Persistence.Entities;

import java.util.Date;

public class Booking {
    private Date dateFrom;
    private Date dateTo;
    private String name;
    private String phoneNum;
    private Room room;
    private Review review;

    public Booking(Date dateFrom, Date dateTo, String name, String phoneNum, Room room, Review review) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.name = name;
        this.phoneNum = phoneNum;
        this.room = room;
        this.review = review;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
