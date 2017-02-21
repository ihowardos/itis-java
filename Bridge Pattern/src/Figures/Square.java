package Figures;

import Characteristics.Color.Color;
import Characteristics.Draw.Draw;

/**
 * Created by Сергей on 21.02.2017.
 */
public class Square extends Shape {

    public Square(Color color, Draw draw) {
        super(color, draw);
    }

    @Override
    public void drawShape() {
        color.paint();
        draw.draw();
    }
}
