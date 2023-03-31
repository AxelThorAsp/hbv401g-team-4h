package hi.is.hbv401gteam4h.Persistence.Entities;

public class Review {
    private float stars;
    private String comment;
    private int roomid;

    public Review(float stars, String comment, int roomid) {
        this.stars = stars;
        this.comment = comment;
        this.roomid = roomid;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRoomid() {
        return roomid;
    }
    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
}
