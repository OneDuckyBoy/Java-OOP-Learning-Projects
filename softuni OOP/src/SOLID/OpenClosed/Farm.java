package SOLID.OpenClosed;

import java.util.List;

public class Farm {
    
        List<Moving> moving;
    
        public void walkAnimals(){
            for (Moving moving :
                    this.moving) {
                moving.move();
            }
        }
}
