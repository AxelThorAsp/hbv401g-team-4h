package hi.is.hbv401gteam4h.Persistence.Entities;

public class Review {
    private float stars;
    private String comment;

    public Review(float stars, String comment) {
        this.stars = stars;
        this.comment = comment;
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
}
