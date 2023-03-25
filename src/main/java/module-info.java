module com.example.hbv401gteam4h {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens hi.is.hbv401gteam4h to javafx.fxml;
    exports hi.is.hbv401gteam4h;
}