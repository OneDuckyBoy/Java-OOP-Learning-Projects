package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.lang.reflect.Method;
import java.util.*;

public class CarRepository implements Repository<Car>{


    private Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return (Car) models.stream().filter(m->m.getModel().equals(name));
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Car model) {
        models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return models.remove(model);
    }
}
