package Builder;

import Builder.Carcases.SedanCarcase;
import Builder.Colors.RedColor;
import Builder.Engines.GasolineEngine;
import Builder.Wheels.SportWheel;

/**
 * Created by Сергей on 02.03.2017.
 */
public class BMWm3 extends CarBuilder {
    @Override
    public void buildWheel() {
        car.wheel(new SportWheel());
    }

    @Override
    public void buildEngine() {
        car.engine(new GasolineEngine());
    }

    @Override
    public void buildCarcase() {
        car.carcase(new SedanCarcase());
    }

    @Override
    public void buildColor() {
        car.color(new RedColor());
    }
}
