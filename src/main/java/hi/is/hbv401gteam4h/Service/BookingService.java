package hi.is.hbv401gteam4h.Service;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Review;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRepository;


import java.util.List;

public class BookingService {
    public static List<Booking> getAllBookings(Room room) {
        return BookingRepository.getBookingsByRoom(room);
    }
    public static List<Booking> getAllBookings() {
        return BookingRepository.getAllBookings();
    }

    public static int addBooking(Booking booking) {
        return BookingRepository.addBooking(booking);
    }

    public static int deleteBooking(Booking booking) {
        return BookingRepository.deleteBooking(booking);
    }
    public static int addReview(Review review) {return BookingRepository.addReview(review);}

    public static String getHotelNameFromBooking(Booking b) { return BookingRepository.getHotelNameFromBooking(b);}


}
