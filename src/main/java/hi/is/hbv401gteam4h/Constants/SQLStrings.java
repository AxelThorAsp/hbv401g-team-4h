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
    public static final String SQLGetBookingsByRoom = """
            SELECT *
            FROM Bookings
            WHERE room = ?
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
    public static final String SQLAddReview = """
            INSERT INTO Reviews (stars, review, room)
            VALUES (?, ?, ?)
            """;

    public static final String SQLGetHotelNameFromBooking = """
            SELECT Hotels.name
            FROM Hotels
            INNER JOIN Rooms ON Hotels.id = Rooms.hotelid
            INNER JOIN Bookings ON Rooms.roomid = Bookings.room
            WHERE Bookings.name = ?
            AND Bookings.phonenum = ?
            """;

    public static final String SQLGetAllReviews = """
            SELECT name, review FROM Reviews
            JOIN Rooms ON Reviews.room = Rooms.roomid
            JOIN Hotels H ON H.id = Rooms.hotelid;
            """;

}
