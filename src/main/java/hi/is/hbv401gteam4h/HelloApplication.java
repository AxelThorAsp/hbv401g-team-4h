package hi.is.hbv401gteam4h;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main1(String[] args) {
        launch();
    }
    public static void main(String[] args) {
        HotelRepository hr = new HotelRepository();
        for(Hotel h: hr.getAllHotels())
            System.out.println(h);
    }
}