package hi.is.hbv401gteam4h.Persistence.Entities;

import java.util.List;

public class HotelIndex {
    private List<Hotel> hotelList;

    public HotelIndex(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}
