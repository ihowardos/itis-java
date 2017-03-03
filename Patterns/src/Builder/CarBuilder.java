package Builder;

/**
 * Created by Сергей on 02.03.2017.
 */
abstract class CarBuilder {
    protected Car car;

    public Car getCar() { return car; }

    public void createCar() {
        this.car = new Car();
    }

    public abstract void buildWheel();
    public abstract void buildEngine();
    public abstract void buildCarcase();
    public abstract void buildColor();
}
