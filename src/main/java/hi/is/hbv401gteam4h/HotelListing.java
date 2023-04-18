package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

import java.io.IOException;

public class HotelListing extends AnchorPane {

    private Hotel hotel;

    @FXML
    private Label name;
    @FXML
    private Label locations; // ekki hægt að nota "location"
    @FXML
    private Label price;
    @FXML
    private Label rating;
    @FXML
    private Label numberOfRooms;

    public Hotel getHotel() {
        return hotel;
    }

    public HotelListing(Hotel h, HotelListController hlist) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hotellisting-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.hotel = h;
        setListing();
        this.setOnMouseClicked(event -> {
            if (hlist.getSelectedPane() != null) {
                hlist.getSelectedPane().setStyle("-fx-background-color: lightgray;");
            }
            hlist.setSelectedPane(this);
            this.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        });
    }

    public void setListing() {
        name.setText(hotel.getName());
        locations.setText(hotel.getCountry() + ", " + hotel.getCity());
        price.setText(hotel.getPrice().toString());
        rating.setText("★ " + hotel.getStars());
        numberOfRooms.setText(hotel.getRoomCapacity() + " herbergi");
    }

}
