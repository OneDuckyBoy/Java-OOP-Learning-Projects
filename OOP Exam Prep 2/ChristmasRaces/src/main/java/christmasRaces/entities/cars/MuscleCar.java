package christmasRaces.entities.cars;

import christmasRaces.entities.cars.BaseCar;

public class MuscleCar extends BaseCar {
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower,5000);
        setLowerRange(400);
        setHigherRange(600);
    }
}
