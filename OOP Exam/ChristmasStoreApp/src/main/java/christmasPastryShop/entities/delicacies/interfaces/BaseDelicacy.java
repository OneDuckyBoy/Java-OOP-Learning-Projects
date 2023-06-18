package christmasPastryShop.entities.delicacies.interfaces;


import java.nio.channels.Pipe;

public abstract class BaseDelicacy implements Delicacy{



    private String name;

    private double portion;
    private double price;
    protected void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or white space!");
        }
        this.name = name;
    }

    protected void setPortion(double portion) {
        if (portion<=0){
            throw new IllegalArgumentException("Portion cannot be less or equal to zero!");
        }
        this.portion = portion;
    }

    protected void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException("Price cannot be less or equal to zero!");
        }
        this.price = price;
    }

    public BaseDelicacy(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return String.format("%s: %.2fg - %.2f",
                getName(),getPortion(),getPrice());
    }
}
