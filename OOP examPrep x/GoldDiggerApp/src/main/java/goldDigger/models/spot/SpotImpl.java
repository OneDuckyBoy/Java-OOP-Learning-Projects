package goldDigger.models.spot;

import java.util.*;

import static goldDigger.common.ExceptionMessages.*;

public class SpotImpl implements Spot{
    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    public Collection<String> getExhibits() {
        return exhibits;
    }

    public void setExhibits(String...exhibitsA){
        exhibits.addAll(List.of(exhibitsA));
    }
    @Override
    public String getName() {
        return name;
    }
}
