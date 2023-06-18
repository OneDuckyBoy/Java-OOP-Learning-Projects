package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.CarRepository;
import christmasRaces.repositories.interfaces.DriverRepository;
import christmasRaces.repositories.interfaces.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerImpl implements Controller {


    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        driverRepository = new DriverRepository();
        carRepository =new CarRepository();
        raceRepository = new RaceRepository();

    }

    @Override
    public String createDriver(String driver) {

        Driver driver1 = new DriverImpl(driver);
        if (driverRepository.getByName(driver).equals(driver1)){
            throw new IllegalArgumentException(String.format("Driver %s is already created.",driver));
        }
        driverRepository.add(driver1);
        return String.format("Driver %s is created.",driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        Car car = null;
        if (type.equals("Muscle")){
            car = new MuscleCar(model,horsePower);
        }else if (type.equals("Sports")){
            car =new SportsCar(model,horsePower);
        }
        if (carRepository.getByName(model).equals(car)){
            throw new IllegalArgumentException(String.format("Car %s is already created.",model));
        }

        carRepository.add(car);
        return String.format("%s %s is created.",type,model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver1 = new DriverImpl(driverName);
        if (!driverRepository.getByName(driverName).equals(driver1)){
            throw new IllegalArgumentException(String.format("Driver %s could not be found.",driverName));
        }
        carRepository.getByName(carModel);
        boolean containsCar = carRepository.getAll().contains(carRepository.getByName(carModel));
        if (!containsCar){
            throw new IllegalArgumentException(String.format("Car %s could not be found.",carModel));
        }

        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));

        return String.format("Driver %s received car %s.",driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        boolean containsRace = raceRepository.getAll().contains(raceRepository.getByName(raceName));
        if (!containsRace){
            throw new IllegalArgumentException(String.format("Race %s could not be found.",raceName));
        }
        Driver driver1 = new DriverImpl(driverName);
        if (!driverRepository.getByName(driverName).equals(driver1)){
            throw new IllegalArgumentException(String.format("Driver %s could not be found.",driverName));
        }
        raceRepository.getByName(raceName).addDriver(driver1);
        return String.format("Driver %s added in %s race.",driverName,raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        boolean containsRace = raceRepository.getAll().contains(raceRepository.getByName(name));
        if (containsRace){
            throw new IllegalArgumentException(String.format("Race %s is already created."));
        }
        Race race = new RaceImpl(name,laps);
        raceRepository.add(race);
        return String.format("Race %s is created.",name);
    }

    @Override
    public String startRace(String raceName) {

        boolean containsRace = raceRepository.getAll().contains(raceRepository.getByName(raceName));
        if (!containsRace){
            throw new IllegalArgumentException(String.format("Race %s could not be found.",raceName));
        }
        boolean containsMoreThan3Or3Participants = raceRepository.getByName(raceName).getDrivers().size() > 2;
        if (!containsMoreThan3Or3Participants) {
            throw new IllegalArgumentException(String.format("Race %s cannot start with less than 3 participants.",raceName));
        }

        Collection<Driver> drivers = raceRepository.getByName(raceName).getDrivers();
        int laps = raceRepository.getByName(raceName).getLaps();
        List<Driver> winners = (List<Driver>) drivers.stream()
                .sorted(Comparator.comparingDouble(driver -> driver.getCar().calculateRacePoints(laps))).limit(3);
        raceRepository.remove(raceRepository.getByName(raceName));
        Driver driver = winners.get(0);
        Driver driver1 = winners.get(1);
        Driver driver2 = winners.get(2);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Driver %s wins %s race.",driver.getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format("Driver %s wins %s race.",driver1.getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format("Driver %s wins %s race.",driver2.getName(),raceName)).append(System.lineSeparator());
        return sb.toString();
    }
}
