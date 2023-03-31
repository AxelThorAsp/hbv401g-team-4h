package hi.is.hbv401gteam4h.Service;

import hi.is.hbv401gteam4h.Persistence.Entities.Booking;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    Room room;
    Booking booking;

    @BeforeEach
    void setUp() {
        room = new Room(99, RoomEnum.ECONOMY, 1);
        booking = new Booking(new Date(0L), new Date(), "Axel", "8949408", 99);
    }

    @AfterEach
    void tearDown() {
        room = null;
        booking = null;
    }

    @Test
    void addDeleteBooking() {
        List<Booking> result1 = BookingService.getAllBookings(room);
        BookingService.addBooking(booking);
        BookingService.deleteBooking(booking);
        List<Booking> result2 = BookingService.getAllBookings(room);
        assertEquals(result1.size(), result2.size());
    }

    @Test
    void getNonExistentBooking() {
        List<Booking> result = BookingService.getAllBookings(room);
        assertEquals(0, result.size());
    }

    @Test
    void getAllBookings() {
        List<Booking> result = BookingService.getAllBookings();
        assertEquals(10, result.size());
    }
    @Test
    void deleteNonExistentBooking() {
        int result = BookingService.deleteBooking(booking);
        assertEquals(0, result);
    }

}