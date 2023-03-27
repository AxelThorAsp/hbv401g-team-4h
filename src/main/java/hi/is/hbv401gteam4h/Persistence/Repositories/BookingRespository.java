package hi.is.hbv401gteam4h.Persistence.Repositories;
import hi.is.hbv401gteam4h.Constants.SQLStrings;
import hi.is.hbv401gteam4h.Persistence.Entities.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class BookingRespository {

    private static Date stringToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }
    private static String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    private static int prepareBookingStatement(Booking booking, PreparedStatement ps) throws SQLException {
        ps.setString(1, dateToString(booking.getDateFrom()));
        ps.setString(2, dateToString(booking.getDateTo()));
        ps.setString(3, booking.getName());
        ps.setString(4, booking.getPhoneNum());
        ps.setInt(5, booking.getRoomid());
        return ps.executeUpdate();
    }
    private static void readBooking(List<Booking> bookings, ResultSet rs) throws SQLException, ParseException {
        while (rs.next()) {
            Date datefrom = stringToDate(rs.getString(1));
            Date dateto = stringToDate(rs.getString(2));
            String name = rs.getString(3);
            String phonenum = rs.getString(4);
            int roomid = rs.getInt(5);
            bookings.add(new Booking(datefrom, dateto, name, phonenum, roomid));
        }
    }

    public static List<Booking> getAllBookings() {
        List<Booking> bookings = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SQLStrings.SQLGetAllBookings)) {
            readBooking(bookings, rs);
        }
        catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static List<Booking> getBookings(Room room, Date dateFrom, Date dateTo) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
             PreparedStatement ps = con.prepareStatement(SQLStrings.SQLGetBooking)) {
            ps.setInt(1, room.getRoomId());
            ps.setString(2, dateToString(dateFrom));
            ps.setString(3, dateToString(dateTo));
            try (ResultSet rs = ps.executeQuery()) {
                readBooking(bookings, rs);
            }
        }
        catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static int addBooking(Booking booking) {
        int lines = 0;
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
            PreparedStatement ps = con.prepareStatement(SQLStrings.SQLInsertBooking)) {
            lines = prepareBookingStatement(booking, ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static int deleteBooking(Booking booking) {
        int lines = 0;
        try (Connection con = DriverManager.getConnection(SQLStrings.dbConnection);
             PreparedStatement ps = con.prepareStatement(SQLStrings.SQLDeleteBooking)) {
            lines = prepareBookingStatement(booking, ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }
}


