package hi.is.hbv401gteam4h.Service;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Entities.HotelIndex;
import hi.is.hbv401gteam4h.Persistence.Entities.Room;
import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import hi.is.hbv401gteam4h.Persistence.Enums.RoomEnum;
import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    public static List<Hotel> searchHotels(String country, String city, HotelPriceEnum priceEnum) {
        List<Hotel> result = new LinkedList<>();
        for (Hotel h: HotelIndex.getHotelList()) {
            if (h.getCountry().equals(country) && h.getCity().equals(city) && h.getPrice().equals(priceEnum))
                result.add(h);
        }
        return result;
    }
    public static List<Hotel> searchHotels(String country) {
        List<Hotel> result = new LinkedList<>();
        for (Hotel h: HotelIndex.getHotelList()) {
            if (h.getCountry().equals(country))
                result.add(h);
        }
        return result;
    }
    public static List<Hotel> searchHotels(HotelPriceEnum priceEnum) {
        List<Hotel> result = new LinkedList<>();
        for (Hotel h: HotelIndex.getHotelList()) {
            if (h.getPrice().equals(priceEnum))
                result.add(h);
        }
        return result;
    }
    public static List<Hotel> searchHotelName(String name) {
        List<Hotel> result = new LinkedList<>();
        for (Hotel h: HotelIndex.getHotelList()) {
            if (h.getName().equals(name))
                result.add(h);
        }
        return result;
    }

    public static List<Room> searchRooms(Hotel hotel, RoomEnum price, int numBeds) {
        return BookingService.findRooms(hotel).stream()
                .filter(r -> r.getType() == price)
                .filter(r -> r.getBedCount() == numBeds)
                .collect(Collectors.toList());
    }

    public static List<Hotel> optionalSearch(String name, List<HotelPriceEnum> priceEnums) {
        List<Hotel> result = new LinkedList<>();
        for (Hotel h: HotelIndex.getHotelList()) {
            if (priceEnums != null && !priceEnums.isEmpty() && !priceEnums.contains(h.getPrice()))
                continue;
            if (name != null && !name.isEmpty() && !h.getName().toLowerCase().matches(".*" + name.toLowerCase() + ".*"))
                continue;
            result.add(h);
        }
        return result;
    }
}
