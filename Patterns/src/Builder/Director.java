package Builder;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Director {
    private CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car getCar() {
        return carBuilder.getCar();
    }

    public void buildCar() {
        carBuilder.createCar();
        carBuilder.buildCarcase();
        carBuilder.buildEngine();
        carBuilder.buildWheel();
        carBuilder.buildColor();
    }
}
