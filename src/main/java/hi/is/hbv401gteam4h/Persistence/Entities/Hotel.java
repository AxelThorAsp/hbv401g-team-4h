package hi.is.hbv401gteam4h.Persistence.Entities;

import java.util.List;

public class Hotel {
    private String name;
    private float stars;
    private String city;
    private int roomCapacity;
    private int price;
    private List<Room> roomList;

    public Hotel(String name, float stars, String city, int roomCapacity, int price, List<Room> roomList) {
        this.name = name;
        this.stars = stars;
        this.city = city;
        this.roomCapacity = roomCapacity;
        this.price = price;
        this.roomList = roomList;
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
