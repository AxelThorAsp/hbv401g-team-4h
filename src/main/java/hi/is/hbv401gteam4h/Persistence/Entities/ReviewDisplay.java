package hi.is.hbv401gteam4h.Persistence.Entities;

public class ReviewDisplay {
    private String hotel;
    private String review;

    public ReviewDisplay(String hotel, String review) {
        this.hotel = hotel;
        this.review = review;
    }
    public String getHotel() {
        return hotel;
    }
    public String getReview() {
        return review;
    }
}
