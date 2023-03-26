package hi.is.hbv401gteam4h.Controllers;

import hi.is.hbv401gteam4h.Persistence.Entities.Hotel;
import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    @Test
    void searchHotelsEnum() {
        List<Hotel> result = SearchController.searchHotels(HotelPriceEnum.HIGH);
        assertEquals(4, result.size());
    }

    @Test
    void searchHotelsCountry() {
        List<Hotel> result = SearchController.searchHotels("USA");
        assertEquals(2, result.size());
    }

    @Test
    void searchHotels() {
        List<Hotel> result = SearchController.searchHotels("USA", "New York",HotelPriceEnum.LOW);
        assertEquals(1,result.size());
    }
    @Test
    void searchHotelsEmpty() {
        List<Hotel> result = SearchController.searchHotels("USA", "New York",HotelPriceEnum.HIGH);
        assertEquals(0,result.size());
    }
    @Test
    void searchHotelName() {
        List<Hotel> result = SearchController.searchHotelName("The Ritz Madrid");
        assertEquals(1,result.size());
    }
}