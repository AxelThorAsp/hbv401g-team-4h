package hi.is.hbv401gteam4h.Persistence.Entities;

import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;

import java.util.List;

public class HotelIndex {
    private static final List<Hotel> hotelList = HotelRepository.getAllHotels();
    public static List<Hotel> getHotelList() {
        return hotelList;
    }
}
