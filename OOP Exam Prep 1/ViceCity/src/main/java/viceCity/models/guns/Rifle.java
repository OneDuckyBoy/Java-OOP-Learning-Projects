package viceCity.models.guns;

import java.util.*;

public class Rifle extends BaseGun{

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_FIRED_WHEN_SHOOTING = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }
    @Override
    public int fire() {

        if (canFire()) {
            setTotalBullets(super.getTotalBullets() - BULLETS_FIRED_WHEN_SHOOTING);
        }
        return BULLETS_FIRED_WHEN_SHOOTING;
    }
}
