package DemoModels;

import Characteristics.Color.ColorBlue;
import Characteristics.Color.ColorGreen;
import Characteristics.Draw.DrawCircle;
import Characteristics.Draw.DrawSquare;
import Figures.Circle;
import Figures.Shape;
import Figures.Square;

/**
 * Created by Сергей on 21.02.2017.
 */
public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle(new ColorGreen(), new DrawCircle(5, 8, 3));
        Shape square = new Square(new ColorBlue(), new DrawSquare(4, 5,  8));

        square.drawShape();
        circle.drawShape();
    }
}
