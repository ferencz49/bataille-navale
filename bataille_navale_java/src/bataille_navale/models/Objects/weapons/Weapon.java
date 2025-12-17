package bataille_navale.models.Objects.weapons;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.Item;

public abstract class Weapon extends Item {

    public Weapon(int capacity, ObjectType objectType) {
        super(capacity, objectType);
    }
    public void useWeapon(Player player, int x, int y){}
    public void onHit(Player player, int x, int y){

    }
}
