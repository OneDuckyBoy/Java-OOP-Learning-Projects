package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun{

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;


    protected void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {

        if (bulletsPerBarrel<0){
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {

        if (bulletsPerBarrel<0){
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        canFire = totalBullets<=0;
        return canFire;
    }

    @Override
    public int getTotalBullets() {
        return getTotalBullets();
    }

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.name = name;
        this.bulletsPerBarrel = bulletsPerBarrel;
        this.totalBullets = totalBullets;
    }


    //Your guns have a barrel, which has a certain capacity for bullets, and you shoot
    // a different count of bullets when you pull the trigger.
    //If your barrel becomes empty, you need to reload before you can shoot again.
    //Reloading is done by refilling the whole barrel of the gun (Keep in mind, that every barrel has capacity).
    //The bullets you take for reloading are taken from the gun's total bullets stock.
    @Override
    public int fire() {
        //in each class
        //t odo
        return 0;
    }
}
