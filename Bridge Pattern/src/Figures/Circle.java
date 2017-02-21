package Figures;

import Characteristics.Color.Color;
import Characteristics.Draw.Draw;

/**
 * Created by Сергей on 21.02.2017.
 */
public class Circle extends Shape {

    public Circle(Color color, Draw draw) {
        super(color, draw);
    }

    @Override
    public void drawShape() {
        color.paint();
        draw.draw();
    }
}
