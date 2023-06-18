package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.Collection;

public interface Repository<T> {

    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
