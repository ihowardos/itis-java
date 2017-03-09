package Composite;

import Composite.Cities.Azn;
import Composite.Cities.Kazan;

/**
 * Created by Сергей on 08.03.2017.
 */
public class Test {
    public static void main(String[] args) {
        Component kzn = new Kazan();
        Component azn = new Azn();

        Composite tatarstan = new Composite();
        Composite russia = new Composite();

        tatarstan.addComponent(kzn);
        tatarstan.addComponent(azn);

        russia.addComponent(tatarstan);
        russia.getComponent();
    }
}
