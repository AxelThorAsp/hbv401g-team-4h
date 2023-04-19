package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Service.BookingService;
import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyBookingListing extends AnchorPane {

    private Booking booking;

    @FXML
    private Label name;
    @FXML
    private Label type;
    @FXML
    private Label roomNum;
    @FXML
    private Label dateFrom;
    @FXML
    private Label dateTo;

    public MyBookingListing(Booking b, MyBookingController blist) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mybookinglisting-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.booking = b;
        setListing();
        this.setOnMouseClicked(event -> {
            if (blist.getSelectedPane() != null) {
                blist.getSelectedPane().setStyle("-fx-background-color: lightgray;");
            }
            blist.setSelectedPane(this);
            this.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        });
    }

    private void setListing() {
        try {
            name.setText(BookingService.getHotelNameFromBooking(booking));
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomNum.setText("Room number: " + booking.getRoomid());
        dateFrom.setText("Date from: " + booking.getDateFrom());
        dateTo.setText("Date to: " + booking.getDateTo());
    }

    public Booking getBooking() {
        return booking;
    }
}
