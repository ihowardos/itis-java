package Builder;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder BMWm3 = new BMWm3();

        director.setCarBuilder(BMWm3);
        director.buildCar();

        Car m3 = director.getCar();
        m3.getWheel();
    }
}
