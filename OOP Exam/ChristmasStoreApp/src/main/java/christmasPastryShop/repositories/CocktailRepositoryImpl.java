package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository {


    private Collection<Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new ArrayList<>();
    }
    @Override
    public Object getByName(String name) {
        return models.stream().filter(c->c.getName().equals(name)).findFirst().orElse(null);//todo orElse
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Object o) {
        models.add((Cocktail) o);
    }
}
