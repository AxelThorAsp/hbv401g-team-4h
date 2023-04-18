package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Service.BookingService;
import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hotellist-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 725, 500);
            stage.setTitle("Hotels");
            stage.setScene(scene);

            stage.setResizable(false);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Booking booking = new Booking(new Date(), new Date(111111111111L), "Axel", "8949408",5);
        BookingService.addBooking(booking);
        BookingService.deleteBooking(booking);
        for (Booking b: BookingService.getAllBookings()) {
            System.out.println(b);
        }

        launch();
    }
}