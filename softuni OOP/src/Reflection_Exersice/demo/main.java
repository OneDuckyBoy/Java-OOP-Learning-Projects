package Reflection_Exersice.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Scanner scanner = new Scanner(System.in);

        Class personClass = Person.class;
        Constructor<Person> constructor= personClass.getConstructor();
        Person pesho;
        pesho = constructor.newInstance(5,"Pesho");
        System.out.println(pesho.getName());

    }
}
