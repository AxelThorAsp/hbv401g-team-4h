package hi.is.hbv401gteam4h.Persistence.Entities;

import java.util.Date;

public class Booking {
    private Date dateFrom;
    private Date dateTo;
    private String name;
    private String phoneNum;
    private int roomid;
    private Review review;

    public Booking(Date dateFrom, Date dateTo, String name, String phoneNum, int roomid) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.name = name;
        this.phoneNum = phoneNum;
        this.roomid = roomid;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roomid=" + roomid +
                '}';
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

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
