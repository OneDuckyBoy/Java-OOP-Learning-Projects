package christmasRaces.entities.cars;


import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    private int LowerRange;
    private int HigherRange;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    protected void setHorsePower(int horsePower) {
        if (!(horsePower<=HigherRange&&horsePower>=LowerRange)){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        this.horsePower = horsePower;
    }

    protected void setModel(String model) {
        if (model==null||model.trim().isEmpty()||model.length()<4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL,model,4));
        }
        this.model = model;
    }


    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }

    protected void setLowerRange(int lowerRange) {
        LowerRange = lowerRange;
    }

    protected void setHigherRange(int higherRange) {
        HigherRange = higherRange;
    }
}
