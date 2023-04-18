package hi.is.hbv401gteam4h;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHotelList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hotellist-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBookingView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("booking-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sayHello(ActionEvent event) {
        System.out.println("hello world");
    }
}
