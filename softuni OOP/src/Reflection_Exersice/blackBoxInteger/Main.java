package Reflection_Exersice.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!"END".equals(command)){

            String methodName = command.split("_")[0];
            int argument = Integer.parseInt(command.split("_")[1]);

            switch (methodName){
                case "add":
                    Method method = clazz.getDeclaredMethod("add", int.class);
                    method.setAccessible(true);
                    method.invoke(blackBoxInt,argument);
                    break;
                case "subtract":
                    break;

            }


            command = scanner.nextLine();
        }
    }
}
