package hi.is.hbv401gteam4h;
import hi.is.hbv401gteam4h.Persistence.Entities.*;

import hi.is.hbv401gteam4h.Vidmot.HotelListing;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HotelListController {

    private HotelIndex hotelIndex;

    @FXML
    private VBox hotelList;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayAllHotels();
    }

    @FXML
    public void displayAllHotels() {
        hotelList.getChildren().clear();
        for (Hotel hotel : hotelIndex.getHotelList()) {
            hotelList.getChildren().add(new HotelListing(hotel));
        }
    }

    private void clearList() {
        hotelList.getChildren().clear();
    }


}
