package goldDigger.models.discoverer;

import java.util.*;

public class Geologist extends BaseDiscoverer{
    private static final double initial_energy = 100;

    public Geologist(String name) {
        super(name, initial_energy);
    }
}
