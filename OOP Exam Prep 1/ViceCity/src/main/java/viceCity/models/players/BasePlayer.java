package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import javax.swing.*;
import java.net.http.HttpRequest;
import java.util.*;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player{

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected void setName(String name) {

        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    protected void setLifePoints(int lifePoints) {

        if (lifePoints<0){
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    public BasePlayer(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
        gunRepository = new GunRepository();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean isAlive() {
        return getLifePoints()>0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        lifePoints-=points;
        if (lifePoints<0){
            lifePoints= 0;
        }
    }

}
