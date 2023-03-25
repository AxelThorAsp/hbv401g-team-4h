package hi.is.hbv401gteam4h.Persistence.Repositories;
import hi.is.hbv401gteam4h.Constants.SQLStrings;
import hi.is.hbv401gteam4h.Persistence.Entities.*;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingRespository {

    public static List<Booking> getBookings(Room room, Date dateFrom, Date dateTo) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
             PreparedStatement ps = con.prepareStatement(SQLStrings.SQLgetBookings)) {
            ps.setInt(1, room.getRoomId());
            ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(dateFrom));
            ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(dateTo));
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

}
