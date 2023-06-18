package Reflection;

import java.lang.reflect.Constructor;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();

        Class<DemoClass> clazz = DemoClass.class;
        Constructor<?> constructors = clazz.getConstructors()[0];

    }
}
