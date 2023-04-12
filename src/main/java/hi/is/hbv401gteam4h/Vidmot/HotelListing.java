package hi.is.hbv401gteam4h.Vidmot;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

import java.io.IOException;

public class HotelListing extends AnchorPane {

    // Viðmótshlutir
    @FXML
    private Label name;
    @FXML
    private Label location;
    @FXML
    private Label price;
    @FXML
    private Label rating;
    @FXML
    private Label numberOfRooms;

    public HotelListing() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hotellisting-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setListing(Hotel hotel) {
        name.setText(hotel.getName());
        location.setText(hotel.getCity() + ", " + hotel.getCountry());
        price.setText(hotel.getPrice().toString());
        rating.setText(String.valueOf(hotel.getStars()));
        numberOfRooms.setText(String.valueOf(hotel.getRoomCapacity()));
    }
}
