package hi.is.hbv401gteam4h;


import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Hotel hotel;
    @FXML
    private Label selectedHotel;
    @FXML
    private ChoiceBox<RoomEnum> roomEnumDropDown;
    @FXML
    private ChoiceBox<Integer> roomNumBeds;
    private RoomEnum selectedRoomEnum;
    private Integer[] rooms = {1,2,3};
    private Integer selectedRoomBeds;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomEnumDropDown.getItems().addAll(RoomEnum.values());
        roomEnumDropDown.setOnAction(this::getRoomPrice);
        roomNumBeds.getItems().addAll(rooms);
        roomNumBeds.setOnAction(this::getRoomNum);
    }
    public BookingViewController() {
    }

    public void getRoomNum(ActionEvent event) {
        this.selectedRoomBeds = roomNumBeds.getValue();
    }
    public void getRoomPrice(ActionEvent event) {
        this.selectedRoomEnum = roomEnumDropDown.getValue();
    }
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void switchToHotelList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hotellist-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sayHello() {
        System.out.println("hello world");
    }

    public void displayHotel() {
        selectedHotel.setText(this.hotel.toString());
    }
}
