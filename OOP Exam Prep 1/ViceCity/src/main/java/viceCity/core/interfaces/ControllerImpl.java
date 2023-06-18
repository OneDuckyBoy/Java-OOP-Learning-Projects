package viceCity.core.interfaces;

import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

public class ControllerImpl implements Controller{
    private Player mainPlayer = new MainPlayer();
    @Override
    public String addPlayer(String name) {
        return null;
    }

    @Override
    public String addGun(String type, String name) {
        return null;
    }

    @Override
    public String addGunToPlayer(String name) {
        return null;
    }

    @Override
    public String fight() {
        return null;
    }
}
