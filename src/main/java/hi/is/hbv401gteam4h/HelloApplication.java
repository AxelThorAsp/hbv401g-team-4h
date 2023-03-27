package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Controllers.BookingController;
import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Entities.HotelIndex;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRespository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// extends Application {
public class HelloApplication {
    //@Override
    //public void start(Stage stage) throws IOException {
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    //    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    //    stage.setTitle("Hello!");
    //    stage.setScene(scene);
    //    stage.show();
    //}

    //public static void main1(String[] args) {
    //    launch();
    //}
    public static void main(String[] args) {
        Booking booking = new Booking(new Date(), new Date(111111111111L), "Axel", "8949408",5);
        BookingController.addBooking(booking);
        BookingController.deleteBooking(booking);
        for (Booking b: BookingController.getAllBookings()) {
            System.out.println(b);
        }
    }
}