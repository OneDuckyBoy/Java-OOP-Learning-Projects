package inheritance;

import java.util.*;

public class demo {
    public static class Vehicle{
        double speed;
        public void stop(){
            speed = 0;
        }
        public void noise(){
            System.out.println("Vroom vroom");
        }
    }
    public static class car extends Vehicle{

        @Override
        public void noise(){
            System.out.println("The car goes vroom vroom");
        }
    }
    public static class Airplane{
        double speed;
        public void stop(){
            speed = 0;
        }
    }
}
