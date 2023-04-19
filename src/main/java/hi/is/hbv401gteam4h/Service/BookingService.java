package hi.is.hbv401gteam4h.Service;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Entities.Review;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import hi.is.hbv401gteam4h.Persistence.Repositories.BookingRepository;
import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;
import hi.is.hbv401gteam4h.util.Util;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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
    public static List<Room> findRooms(Hotel hotel) {return HotelRepository.getRoomsByHotel(hotel);}

    public static List<Room> getAvailableRooms(Hotel hotel, RoomEnum price, int numBeds, Date dateFrom, Date dateTo) {
        List<Room> retval = new ArrayList<>();
        for (var r : SearchService.searchRooms(hotel, price, numBeds)) {
            if (BookingService.getAllBookings(r).stream()
                    .allMatch(
                            b -> !(Util.between(b.getDateFrom(), dateFrom, dateTo)
                            || Util.between(b.getDateTo(), dateFrom, dateTo))
                    ))
            {
             retval.add(r);
            };
        }
        return retval;
    }

    public static String getHotelNameFromBooking(Booking b) { return BookingRepository.getHotelNameFromBooking(b);}


}

