package Figures;

import Characteristics.Color.Color;
import Characteristics.Draw.Draw;

/**
 * Created by Сергей on 21.02.2017.
 */
public abstract class Shape {
    protected Color color;
    protected Draw draw;

    public Shape(Color color, Draw draw) {
        this.color = color;
        this.draw = draw;
    }

    public abstract void drawShape();
}
