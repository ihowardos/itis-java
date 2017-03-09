package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 08.03.2017.
 */
public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void getComponent() {
        for (int i = 0; i < components.size(); i++ ) {
            components.get(i).getComponent();
        }
    }
}
