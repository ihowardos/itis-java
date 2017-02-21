package Characteristics.Draw;

/**
 * Created by Сергей on 21.02.2017.
 */
public class DrawCircle implements Draw {
    private int radius, x, y;

    public DrawCircle(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw() {
        System.out.println("circle with radius " + radius + " and center (" + x + ", " + y + ")");
    }
}
