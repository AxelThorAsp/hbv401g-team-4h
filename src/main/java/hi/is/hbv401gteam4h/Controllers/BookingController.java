package hi.is.hbv401gteam4h.Controllers;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRespository;

import java.util.Date;
import java.util.List;

public class BookingController {
    public static List<Booking> getAllBookings(Room room) {
        return BookingRespository.getBookings(room, new Date(0L), new Date(6999999999999L));
    }
}
