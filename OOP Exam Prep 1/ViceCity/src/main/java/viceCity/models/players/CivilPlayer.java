package viceCity.models.players;

import java.util.*;

public class CivilPlayer extends BasePlayer{

    private static final int DEFAULT_LIFE_POINTS = 50;

    public CivilPlayer(String name) {
        super(name, DEFAULT_LIFE_POINTS);
    }
}
