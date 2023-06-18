package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;


public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved = false;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
    }

    protected void setCapacity(int capacity) {
        if (capacity<=0){//todo ima =
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople<=0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        price = this.numberOfPeople*pricePerPerson;
    }

    @Override
    public double getBill() {
        double bill = price;
        if (!delicacyOrders.isEmpty()){
            for (Delicacy delicacyOrder : delicacyOrders) {
                bill+= delicacyOrder.getPrice();
            }
        }
        if (!cocktailOrders.isEmpty()){
            for (Cocktail cocktail : cocktailOrders) {
                bill+=cocktail.getPrice();
            }
        }
        return bill;
    }

    @Override
    public void clear() {
        cocktailOrders.clear();
        delicacyOrders.clear();
        isReserved = false;
        numberOfPeople = 0;
        price = 0;
    }
}
