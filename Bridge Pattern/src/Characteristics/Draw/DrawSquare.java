package Characteristics.Draw;

/**
 * Created by Сергей on 21.02.2017.
 */
public class DrawSquare implements Draw {
    private int side, x, y;

    public DrawSquare(int side, int x, int y) {
        this.side = side;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("square with side " + side + " and center (" + x + ", " + y + ")");
    }
}
