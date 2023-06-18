package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;

import java.util.*;

public class DriverRepository implements Repository{


    private Collection<DriverImpl> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        return models.stream().filter(m->m.getName().equals(name)).findFirst();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object model) {
        models.add((DriverImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        return models.remove(model);
    }
}
