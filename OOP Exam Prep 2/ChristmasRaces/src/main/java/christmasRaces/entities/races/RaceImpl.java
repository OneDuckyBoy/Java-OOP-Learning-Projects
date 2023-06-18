package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import javax.swing.*;
import java.util.*;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race{
    private String name;
    private int laps;
    private Collection<Driver>drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
    }
    protected void setName(String name) {
        if (name==null||name.trim().isEmpty()||name.length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
        this.name = name;
    }
    protected void setLaps(int laps) {

        if (laps<1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,1));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null){
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        if (!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        if (drivers.contains(driver)){
            String driverName = driver.getName();
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED,driverName,getName()));
        }
        drivers.add(driver);
    }


}
