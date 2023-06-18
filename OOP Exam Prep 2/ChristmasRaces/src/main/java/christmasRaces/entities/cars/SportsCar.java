package christmasRaces.entities.cars;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower,3000);
        setLowerRange(250);
        setHigherRange(450);
    }
}
