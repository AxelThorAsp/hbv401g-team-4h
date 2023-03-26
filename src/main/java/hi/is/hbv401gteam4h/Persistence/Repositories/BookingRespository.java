package hi.is.hbv401gteam4h.Persistence.Repositories;
import hi.is.hbv401gteam4h.Constants.SQLStrings;
import hi.is.hbv401gteam4h.Persistence.Entities.*;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingRespository {

    private static Date stringToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }

    public static List<Booking> getBookings(Room room, Date dateFrom, Date dateTo) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
             PreparedStatement ps = con.prepareStatement(SQLStrings.SQLgetBookings)) {
            ps.setInt(1, room.getRoomId());
            ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(dateFrom));
            ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(dateTo));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Date datefrom = stringToDate(rs.getString(1));
                    Date dateto = stringToDate(rs.getString(2));
                    String name = rs.getString(3);
                    String phonenum = rs.getString(4);
                    int roomid = rs.getInt(5);
                    bookings.add(new Booking(datefrom, dateto, name, phonenum, roomid));
                }
            }
        }
        catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}


