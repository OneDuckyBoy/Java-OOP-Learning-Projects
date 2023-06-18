package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;

import java.util.*;

public class RaceRepository implements Repository{
    //TODO

    private Collection<RaceImpl> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        return models.stream().filter(m ->m.getName().equals(name)).findFirst();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object model) {
        models.add((RaceImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        return models.remove(model);
    }
}
