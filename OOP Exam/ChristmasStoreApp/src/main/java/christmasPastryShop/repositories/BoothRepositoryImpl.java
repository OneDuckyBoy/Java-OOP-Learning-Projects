package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository {

    private Collection<Booth> models;

    public BoothRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByNumber(int number) {

        for (Booth model : models) {
            if (model.getBoothNumber()==number){
                return model;
            }
        }
        return null;
        //return models.stream().filter(b -> b.getBoothNumber()==number ).findFirst().orElse(null);//todo orElse(null)

    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object o) {

        models.add((Booth) o);
    }
}
