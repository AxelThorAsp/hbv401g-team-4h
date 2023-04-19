package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewListController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private VBox reviewList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayAllReviews();
    }
    public void switchToHotelList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hotellist-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void displayAllReviews() {
        for (var r: BookingRepository.getAllReviews()) {
            reviewList.getChildren().add(new ReviewListing(r, this));
        }
    }
}
