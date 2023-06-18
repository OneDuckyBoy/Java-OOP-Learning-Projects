package collection;

import java.util.*;

public abstract class Collection {
    private int maxSize;
    protected List<String> items;

    public Collection(int maxSize) {
        items = new ArrayList<>();
        maxSize= 100;
    }
}
