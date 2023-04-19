package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Persistence.Entities.ReviewDisplay;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReviewListing extends AnchorPane {

    @FXML
    private TextArea textArea;
    @FXML
    private Label hotelNameLabel;

    private ReviewDisplay review;
    public ReviewListing(ReviewDisplay rd, ReviewListController rlist) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reviewListing.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.review = rd;
        setListing(rd);
    }

    public void setListing(ReviewDisplay rd) {
        textArea.setText(rd.getReview());
        hotelNameLabel.setText(rd.getHotel());
        textArea.setEditable(false);
    }
}
