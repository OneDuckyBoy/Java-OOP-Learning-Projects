package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    //TODO: Test Garage class
    private Garage garage;
    private Car car;
    private Car car1;
    @Before
    public void setUp(){
        garage = new Garage();
        car = new Car("car1",200,20000);
        car1 = new Car("car2",150,10000);
    }
    @Test
    public void testGetCount(){
        assertEquals(0,garage.getCount());
    }
    @Test
    public void testAddCar(){
        garage.addCar(car);
        assertEquals(1,garage.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCar(){
        Car car3 = null;
        garage.addCar(car3);
    }

    @Test
    public void testNullGetTheMostExpensiveCar(){
        assertEquals(null, garage.getTheMostExpensiveCar());
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(car);
        garage.addCar(car1);
        assertEquals(car, garage.getTheMostExpensiveCar());
    }
    @Test
    public void testEmptyFindAllCarsByBrand(){
        garage.addCar(car);
        garage.addCar(car1);
        garage.findAllCarsByBrand("a");
        List<Car> list = new ArrayList<>();
        assertEquals(list,garage.findAllCarsByBrand("a"));
    }

    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(car);
        garage.addCar(car1);
        garage.findAllCarsByBrand("a");
        List<Car> list = new ArrayList<>();
        list.add(car);
        assertEquals(list,garage.findAllCarsByBrand("car1"));
    }
    @Test
    public void testEmptyFindAllCarsWithMaxSpeedAbove(){
        List<Car> list = new ArrayList<>();
        assertEquals(list,garage.findAllCarsWithMaxSpeedAbove(200));
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        List<Car> list = new ArrayList<>();
        garage.addCar(car);
        garage.addCar(car1);
        list.add(car);
        assertEquals(list,garage.findAllCarsWithMaxSpeedAbove(150));
    }
    @Test
    public void testGetCars(){
        garage.addCar(car);
        garage.addCar(car1);
        List<Car> list = new ArrayList<>();
        list.add(car);
        list.add(car1);
        assertEquals(list,garage.getCars());
    }
    @Test(expected = NullPointerException.class)
    public void testNullGetCars(){
        Garage garage1 = null;
        garage1.addCar(car);
        garage1.addCar(car1);
        List<Car> list = new ArrayList<>();
        list.add(car);
        list.add(car1);
    }

}