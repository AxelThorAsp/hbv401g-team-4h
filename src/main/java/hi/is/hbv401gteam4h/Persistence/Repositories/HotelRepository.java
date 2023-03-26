package hi.is.hbv401gteam4h.Persistence.Repositories;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Constants.SQLStrings;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;

import java.sql.*;
import java.util.*;

public class HotelRepository {
    private static final Map<Integer, RoomEnum> intToRoomEnum = new HashMap<Integer, RoomEnum>();
    static {
        for (RoomEnum type : RoomEnum.values()) {
            intToRoomEnum.put(type.ordinal() , type);
        }
    }
    private static final Map<Integer, HotelPriceEnum> intToPriceEnum = new HashMap<Integer, HotelPriceEnum>();
    static {
        for (HotelPriceEnum type : HotelPriceEnum.values()) {
            intToPriceEnum.put(type.ordinal() , type);
        }
    }
    public static List<Hotel> getAllHotels() {
        List<Hotel> hotels = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLStrings.SQLGetAllHotels)) {
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float stars = rs.getFloat(3);
                String country = rs.getString(4);
                String city = rs.getString(5);
                int numrooms = rs.getInt(6);
                HotelPriceEnum hotelprice = intToPriceEnum.get(rs.getInt(7));
                hotels.add(new Hotel(id, name, stars, country,
                        city, numrooms, hotelprice));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }
    public static List<Room> getRoomsByHotel(int hotelid) {
        List<Room> rooms = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
            PreparedStatement ps = con.prepareStatement(SQLStrings.SQLGetRoomsByHotel)) {
            ps.setInt(1, hotelid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int roomid = rs.getInt(1);
                    RoomEnum type = intToRoomEnum.get(rs.getInt(2) - 1);
                    int bedcount = rs.getInt(3);
                    rooms.add(new Room(roomid, type, bedcount));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
