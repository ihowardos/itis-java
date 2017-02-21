package models;

/**
 * Created by Сергей on 26.11.2016.
 */
public class Prison {
    int id;
    String name;
    String city;
    int capacity;
    int wardenId;

    public Prison(String name, String city, int capacity, int wardenId) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.wardenId = wardenId;
    }

    public Prison(int id, String name, String city, int capacity, int wardenId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.wardenId = wardenId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWardenId() {
        return wardenId;
    }
}
