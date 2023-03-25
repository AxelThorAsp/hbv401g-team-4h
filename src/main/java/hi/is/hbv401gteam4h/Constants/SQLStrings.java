package hi.is.hbv401gteam4h.Constants;

public class SQLStrings {

    public static final String dbConnection = "jdbc:sqlite:src/db/db.db";

    public static final String SQLgetAllHotels = """
            SELECT *
            FROM Hotels
            """;
    public static final String SQLgetRoomsByHotel = """
            SELECT *
            FROM Rooms
            WHERE hotelid = ?
            """;
}
