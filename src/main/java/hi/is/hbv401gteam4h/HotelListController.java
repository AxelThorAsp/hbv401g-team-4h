package hi.is.hbv401gteam4h;
import hi.is.hbv401gteam4h.Persistence.Entities.*;

import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HotelListController implements Initializable {

    private HotelIndex hotelIndex;

    @FXML
    private VBox hotelList;
    @FXML
    private TextField searchBar;
    @FXML
    private CheckBox lowPrice;
    @FXML
    private CheckBox midPrice;
    @FXML
    private CheckBox highPrice;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;

    private AnchorPane selectedPane;

    public AnchorPane getSelectedPane() {
        return selectedPane;
    }

    public void setSelectedPane(AnchorPane selectedPane) {
        this.selectedPane = selectedPane;
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayAllHotels();
    }

    @FXML
    public void displayAllHotels() {
        clearList();
        for (Hotel hotel : hotelIndex.getHotelList()) {
            hotelList.getChildren().add(new HotelListing(hotel, this));
        }
    }

    private void clearList() {
        hotelList.getChildren().clear();
    }

    @FXML
    public void search() {
        System.out.println("Searching...");
        System.out.println("Searchbar: " + searchBar.getText() + ", low: " + lowPrice.isSelected() + ", mid: " + midPrice.isSelected() + ", high: " + highPrice.isSelected() + ", from: " + fromDate.getValue() + ", to: " + toDate.getValue());

        // Á eftir að útfæra
        // nota variables: searchBar, lowPrice, midPrice, highPrice, fromDate, toDate
    }
}
