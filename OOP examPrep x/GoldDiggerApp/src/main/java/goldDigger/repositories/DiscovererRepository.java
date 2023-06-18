package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.*;

public class DiscovererRepository implements Repository<Discoverer>{

    private Map<String,Discoverer>discoverers;//todo
    private Object entity;

    public DiscovererRepository() {
        this.discoverers = new LinkedHashMap<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(discoverers.values());
    }

    @Override
    public void add(Discoverer discoverer) {
        discoverers.put(discoverer.getName(),discoverer);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return discoverers.remove(entity.getName())!=null;
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.get(name);
    }
}
