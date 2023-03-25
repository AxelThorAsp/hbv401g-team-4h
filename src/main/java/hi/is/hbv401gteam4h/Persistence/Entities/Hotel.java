package hi.is.hbv401gteam4h.Persistence.Entities;

import hi.is.hbv401gteam4h.Persistence.Repositories.HotelRepository;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private float stars;
    private String city;
    private int roomCapacity;
    private int price;
    private List<Room> roomList;

    public Hotel(int id, String name, float stars, String city, int roomCapacity, int price) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.city = city;
        this.roomCapacity = roomCapacity;
        this.price = price;
        this.roomList = HotelRepository.getRoomsByHotel(id);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", city='" + city + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", price=" + price +
                ", roomList=" + roomList +
                '}';
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
