package hi.is.hbv401gteam4h;

import java.time.ZoneId;
import java.util.Date;
import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import hi.is.hbv401gteam4h.Service.BookingService;
import hi.is.hbv401gteam4h.Service.SearchService;
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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
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
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;
    @FXML
    private TextField nameInp;
    @FXML
    private TextField phoneNumInp;
    @FXML
    private Button bookButton;
    private RoomEnum selectedRoomEnum;
    private Integer[] rooms = {1,2};
    private Integer selectedRoomBeds;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomEnumDropDown.getItems().addAll(RoomEnum.values());
        roomEnumDropDown.setOnAction(this::getRoomPrice);
        roomNumBeds.getItems().addAll(rooms);
        roomNumBeds.setOnAction(this::getRoomNum);
        bookButton.setOnAction(this::confirmBooking);
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

    public void confirmBooking(ActionEvent event) {
        try {
            Date df = toUtilDate(dateFrom.getValue());
            Date dt = toUtilDate(dateTo.getValue());
            RoomEnum roomPrice = roomEnumDropDown.getValue();
            Integer numBeds = roomNumBeds.getValue();
            Hotel hotelSelected = this.hotel;
            String name = nameInp.getText();
            String phonenum = phoneNumInp.getText();
            System.out.println(hotelSelected);
            System.out.println("hello world");
            List<Room> rooms = BookingService.getAvailableRooms(hotelSelected, roomPrice, numBeds, df, dt);
            if (rooms.isEmpty()){
                showNoRoomsFound();
                return;
            }
            else {
                Room room = rooms.get(0);
                Booking booking = new Booking(df,dt, name, phonenum, room.getRoomId());
                BookingService.addBooking(booking);
                showSuccess();
            }
        }
        catch (NullPointerException e) {
            showError();
        }
    }

    public void displayHotel() {
        selectedHotel.setText(this.hotel.toString());
    }

    private Date toUtilDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Missing fields");
        alert.setHeaderText(null);
        alert.setContentText("Make sure you filled out all the necessary fields");
        alert.showAndWait();
    }
    private void showNoRoomsFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No rooms found");
        alert.setHeaderText(null);
        alert.setContentText("Sorry, no rooms were found according to the provided fields");
        alert.showAndWait();
    }
    private void showSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succeess");
        alert.setHeaderText(null);
        alert.setContentText("You have booked your room");
        alert.showAndWait();
    }
}
