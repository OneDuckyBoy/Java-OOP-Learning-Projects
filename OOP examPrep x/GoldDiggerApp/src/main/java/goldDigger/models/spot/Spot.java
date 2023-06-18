package goldDigger.models.spot;

import java.util.Collection;

public interface Spot {

    Collection<String> getExhibits();

    String getName();

    void setExhibits(String[] exhibits);
}
