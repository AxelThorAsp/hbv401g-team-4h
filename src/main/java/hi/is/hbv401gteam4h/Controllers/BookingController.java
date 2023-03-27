package hi.is.hbv401gteam4h.Controllers;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRespository;


import java.util.List;

public class BookingController {
    public static List<Booking> getAllBookings(Room room) {
        return BookingRespository.getBookingsByRoom(room);
    }
    public static List<Booking> getAllBookings() {
        return BookingRespository.getAllBookings();
    }

    public static int addBooking(Booking booking) {
        return BookingRespository.addBooking(booking);
    }

    public static int deleteBooking(Booking booking) {
        return BookingRespository.deleteBooking(booking);
    }
}
