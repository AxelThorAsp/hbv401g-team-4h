package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Review;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import hi.is.hbv401gteam4h.Service.BookingService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MyBookingController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private MyBookingListing selectedPane;

    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label errorMessage;
    @FXML
    private Label noBookings;
    @FXML
    private VBox bookingList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearList();
    }

    public void getBookings() {
        clearList();
        noBookings.setVisible(false);
        String name = nameField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || phone.isEmpty()) {
            errorMessage.setVisible(true);
        } else {
            errorMessage.setVisible(false);
        }

        int found = 0;
        for (Booking b: BookingService.getAllBookings()) {
            if(b.getName().equals(name) && b.getPhoneNum().equals(phone)) {
                bookingList.getChildren().add(new MyBookingListing(b, this));
                found = 1;
            }
        }
        if(found == 0) {
            noBookings.setVisible(true);
        }
    }

    public void switchToHotelList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hotellist-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void clearList() {
        bookingList.getChildren().clear();
    }

    public MyBookingListing getSelectedPane() {
        return selectedPane;
    }

    public void setSelectedPane(MyBookingListing selectedPane) {
        this.selectedPane = selectedPane;
    }

    public void unBook(ActionEvent event) throws IOException {
        Booking booking = selectedPane.getBooking();
        if (booking != null) {
            BookingService.deleteBooking(booking);
            getBookings();
        }
        else {
            // TODO show error;
        }
    }

    public void addReview(ActionEvent event) throws IOException {
        Booking booking = selectedPane.getBooking();
        if (booking != null) {
            String rev;
            TextInputDialog tiDialog = new TextInputDialog();
            tiDialog.setTitle("Add review");
            tiDialog.setHeaderText("Enter your review");
            tiDialog.setContentText("Review: ");
            Optional<String> resp = tiDialog.showAndWait();
            if(resp.isPresent()) {
                rev = resp.get();
                BookingService.addReview(new Review(5, rev, booking.getRoomid()));
                showSuccess();
            }
        }
    }
    private void showSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Review added");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for your feedback");
        alert.showAndWait();
    }
}
