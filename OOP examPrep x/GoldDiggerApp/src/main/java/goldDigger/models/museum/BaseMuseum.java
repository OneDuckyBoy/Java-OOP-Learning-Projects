package goldDigger.models.museum;

import java.util.*;

public class BaseMuseum implements Museum{
    private Collection<String> exhibits;

    public BaseMuseum() {
        exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
