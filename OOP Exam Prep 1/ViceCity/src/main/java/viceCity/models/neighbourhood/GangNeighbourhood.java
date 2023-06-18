package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.*;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
    //TODO
        List<Player> playerList= civilPlayers.stream().toList();
        int index = 0;

        Collection<Gun> guns = (Collection<Gun>) mainPlayer.getGunRepository();
        for (Gun gun : guns) {
            boolean theCiviliansAreDead = playerList.size()==index;
            while (gun.canFire()){
                int bulletsShot = gun.fire();//1
                if (playerList.get(index).isAlive()){
                    playerList.get(index).takeLifePoints(bulletsShot);
                }
                else {
                    index++;
                }
                theCiviliansAreDead = playerList.size()==index;
                if (theCiviliansAreDead){
                    break;
                }
            }
            if (theCiviliansAreDead){
                break;
            }
        }

    }
}
