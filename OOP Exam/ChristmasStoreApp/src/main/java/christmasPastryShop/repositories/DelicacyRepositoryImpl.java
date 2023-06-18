package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository {
    private Collection<Delicacy> models;

    public DelicacyRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        return models.stream().filter(d->d.getName().equals(name)).findFirst().orElse(null);//todo orElse
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object o) {
        models.add((Delicacy) o);
    }
}
