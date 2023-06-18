package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.OutputMessages.BILL;
import static christmasPastryShop.common.OutputMessages.TOTAL_INCOME;

public class ControllerImpl implements Controller {

    private double totalIncome;
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.boothRepository = boothRepository;
        this.cocktailRepository = cocktailRepository;
        this.delicacyRepository = delicacyRepository;
        totalIncome = 0;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy;
        if (type.equals("Gingerbread")){
            delicacy = new Gingerbread(name,price);
        }else {
            delicacy = new Stolen(name,price);
        }
        if (delicacyRepository.getAll().contains(delicacyRepository.getByName(name))){
            throw new IllegalArgumentException(String.format("%s %s is already in the pastry shop!",type,name));
        }
        delicacyRepository.add(delicacy);
        return String.format("Added delicacy %s - %s to the pastry shop!",name,type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        Cocktail cocktail;
        if (type.equals("Hibernation")){
            cocktail = new Hibernation(name,size,brand);
        }
        else {
            cocktail = new MulledWine(name,size,brand);
        }
        boolean containsCocktail = cocktailRepository.getAll().contains(cocktailRepository.getByName(name));
        if (containsCocktail){
            throw new IllegalArgumentException(String.format("%s %s is already in the pastry shop!",type,name));
        }
        cocktailRepository.add(cocktail);
        return String.format("Added cocktail %s - %s to the pastry shop!",name,brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

        Booth booth;
        if (type.equals("OpenBooth")){
            booth = new OpenBooth(boothNumber,capacity);
        }else {
            booth = new PrivateBooth(boothNumber,capacity);
        }
        boolean containsBooth = boothRepository.getAll().contains(boothRepository.getByNumber(boothNumber));
        if (containsBooth){
            throw new IllegalArgumentException(String.format("Booth %d is already added to the pastry shop!",boothNumber));
        }
        boothRepository.add(booth);
        return String.format("Added booth number %d in the pastry shop!",boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        int numOfBooth = -1;
        for (Booth booth : boothRepository.getAll()) {
            if (!booth.isReserved()/* true */&&booth.getCapacity()/* 20 */>=numberOfPeople/* 5 */){
                //hasAvailableBooth = true;
                numOfBooth= booth.getBoothNumber();
                break;
            }
        }
        if (numOfBooth==-1){
            return String.format("No available booth for %d people!",numberOfPeople);
        }

        boothRepository.getByNumber(numOfBooth).reserve(numberOfPeople);
        return String.format("Booth %d has been reserved for %d people!",numOfBooth,numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        double bill =  boothRepository.getByNumber(boothNumber).getBill();
        totalIncome+=bill;
        boothRepository.getByNumber(boothNumber).clear();



        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {

        return String.format(TOTAL_INCOME,totalIncome);
    }
}
