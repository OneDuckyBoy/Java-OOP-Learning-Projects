package viceCity.repositories.interfaces;


import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository{


    private Collection<Gun> models;//unmodifiable

    @Override
    public Collection getModels() {

        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object model) {
        if (!models.contains(model)){
            models.add((Gun) model);
        }
    }

    @Override
    public boolean remove(Object model) {

        return models.remove(model);
    }

    @Override
    public Object find(String name) {
        //t odo
        return models.stream().filter(g->g.getName().equals(name)).findFirst();
    }
}
