package hi.is.hbv401gteam4h;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label selectedHotel;

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

    public void displayHotel(HotelListing hotelListing) {
        selectedHotel.setText(hotelListing.getHotel().toString());
    }
}
