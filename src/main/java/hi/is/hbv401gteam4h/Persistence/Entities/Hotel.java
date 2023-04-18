package hi.is.hbv401gteam4h.Persistence.Entities;

import hi.is.hbv401gteam4h.Persistence.Enums.HotelPriceEnum;
import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private float stars;
    private String country;
    private String city;
    private int roomCapacity;

    private HotelPriceEnum hotelPriceEnum;
    private List<Room> roomList;

    public Hotel(int id, String name, float stars,
                 String country, String city, int roomCapacity, HotelPriceEnum price) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.country = country;
        this.city = city;
        this.roomCapacity = roomCapacity;
        this.hotelPriceEnum = price;
        this.roomList = HotelRepository.getRoomsByHotel(id);
    }

    @Override
    public String toString() {
        return "" + name + ", " + city + " " + country ;
    }

    public int getId() {return id;}
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public HotelPriceEnum getPrice() {
        return hotelPriceEnum;
    }

    public void setPrice(HotelPriceEnum price) {
        this.hotelPriceEnum = price;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
