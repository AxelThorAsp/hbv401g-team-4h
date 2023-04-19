package hi.is.hbv401gteam4h;
import hi.is.hbv401gteam4h.Persistence.Entities.*;

import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import hi.is.hbv401gteam4h.Service.SearchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private Stage stage;
    private Scene scene;
    private Parent root;

    private HotelListing selectedPane;

    public HotelListing getSelectedPane() {
        return selectedPane;
    }

    public void setSelectedPane(HotelListing selectedPane) {
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
        List<HotelPriceEnum> selectedPrices = new ArrayList<>();
        if (lowPrice.isSelected()) {
            selectedPrices.add(HotelPriceEnum.LOW);
        }
        if (midPrice.isSelected()) {
            selectedPrices.add(HotelPriceEnum.MEDIUM);
        }
        if (highPrice.isSelected()) {
            selectedPrices.add(HotelPriceEnum.HIGH);
        }

        SearchService searchService = new SearchService();
        List<Hotel> foundHotels = searchService.optionalSearch(searchBar.getText(), selectedPrices);
        displayHotels(foundHotels);
    }

    private void displayHotels(List<Hotel> hotels) {
        clearList();
        for (Hotel hotel : hotels) {
            hotelList.getChildren().add(new HotelListing(hotel, this));
        }
    }

    public void switchToBookingView(ActionEvent event) throws IOException {
        if (selectedPane == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No hotel selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a hotel");
            alert.showAndWait();
            return;
        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("booking.fxml"));
        root = loader.load();
        BookingViewController bookingViewController = loader.getController();
        bookingViewController.setHotel(selectedPane.getHotel());
        bookingViewController.displayHotel();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 725, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMyBookingView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mybooking-view.fxml"));
        root = loader.load();
        //MyBookingController myBookingController = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 725, 500);
        stage.setScene(scene);
        stage.show();
    }
}
