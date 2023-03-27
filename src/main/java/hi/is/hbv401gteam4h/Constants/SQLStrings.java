package hi.is.hbv401gteam4h.Constants;

public class SQLStrings {

    public static final String dbConnection = "jdbc:sqlite:src/db/db.db";

    public static final String SQLGetAllHotels = """
            SELECT *
            FROM Hotels
            """;
    public static final String SQLGetAllBookings = """
            SELECT *
            FROM Bookings
            """;
    public static final String SQLGetRoomsByHotel = """
            SELECT *
            FROM Rooms
            WHERE hotelid = ?
            """;
    public static final String SQLGetBooking = """
            SELECT *
            FROM Bookings
            WHERE room = ?
            AND datefrom = ?
            AND dateto = ?
            """;
    public static final String SQLInsertBooking = """
            INSERT INTO Bookings (datefrom, dateto, name, phonenum, room)
            VALUES (?, ?, ?, ?, ?)
            """;
    public static final String SQLDeleteBooking = """
            DELETE
            FROM Bookings
            WHERE datefrom = ?
            AND dateto = ?
            AND name = ?
            AND phonenum = ?
            AND room = ?
            """;
}
