package bataille_navale.models.Objects.weapons;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.items.Item;

public abstract class Weapon extends Item {

    public Weapon(int capacity) {
        super(capacity);
    }
    public void useWeapon(Player player, int x, int y){}
    public void onHit(Player player, int x, int y){

    }
}
