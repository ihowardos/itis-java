package Builder;

import Builder.Carcases.Carcase;
import Builder.Colors.Color;
import Builder.Engines.Engine;
import Builder.Wheels.Wheel;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Car {

    private Wheel wheel;
    private Engine engine;
    private Carcase carcase;
    private Color color;

    public Wheel getWheel() {
        wheel.setWheel();
        return wheel;
    }

    public Engine getEngine() {
        engine.setEngine();
        return engine;
    }

    public Carcase getCarcase() {
        carcase.setCarcase();
        return carcase;
    }

    public Color getColor() {
        color.setColor();
        return color;
    }

    public void wheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void engine(Engine engine) {
        this.engine = engine;
    }

    public void carcase(Carcase carcase) {
        this.carcase = carcase;
    }

    public void color(Color color) {
        this.color = color;
    }
}
