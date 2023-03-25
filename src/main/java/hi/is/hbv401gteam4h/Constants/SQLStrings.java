package hi.is.hbv401gteam4h.Constants;

public class SQLStrings {

    public static String dbConnection = "jdbc:sqlite:src/db/db.db";

    public static String SQLgetAllCountries = """
            SELECT *
            FROM Hotels
            """;
    public static String SQLgetRoomsByHotel = """
            SELECT *
            FROM Rooms
            WHERE hotelid = ?
            """;
}
