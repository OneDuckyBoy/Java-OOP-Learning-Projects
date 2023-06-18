package christmasPastryShop.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    //Collection<T> models();

    Collection<T> getAll();

    void add(T t);

}
