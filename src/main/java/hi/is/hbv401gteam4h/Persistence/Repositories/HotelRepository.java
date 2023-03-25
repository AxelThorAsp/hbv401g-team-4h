package hi.is.hbv401gteam4h.Persistence.Repositories;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Constants.SQLStrings;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLStrings.SQLgetAllCountries)) {
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float stars = rs.getFloat(3);
                String city = rs.getString(4);
                int numrooms = rs.getInt(5);
                int hotelprice = rs.getInt(6);
                hotels.add(new Hotel(id, name, stars, city,
                        numrooms, hotelprice, new ArrayList<Room>()));
            }
        }

         catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }
}
