package models;

/**
 * Created by Сергей on 06.12.2016.
 */
public class Article {
    int number;
    String description;

    public Article(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
