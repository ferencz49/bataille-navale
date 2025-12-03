package bataille_navale.models.items.weapons;

import bataille_navale.models.items.Item;

public abstract class Weapon extends Item {

    public Weapon(int capacity) {
        super(capacity);
    }

    public void useWeapon(int x, int y){}
}
