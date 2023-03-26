package hi.is.hbv401gteam4h.Controllers;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Entities.HotelIndex;
import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchController {
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
}
