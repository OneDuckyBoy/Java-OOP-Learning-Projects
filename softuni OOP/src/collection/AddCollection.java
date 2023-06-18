package collection;

import java.util.*;

public class AddCollection extends Collection implements Addable{
    public AddCollection(int maxSize) {
        super(maxSize);
    }

    @Override
    public int add(String item){

        super.items.add(item);
        return items.size()-1;
    }
}
