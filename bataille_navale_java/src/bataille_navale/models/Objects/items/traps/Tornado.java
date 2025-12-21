package bataille_navale.models.Objects.items.traps;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.weapons.Bomb;

public class Tornado extends Trap {
    private boolean canBePlaced = true;

    public Tornado(int capacity){
        super(capacity);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }

    public void onHit(Player player, int x, int y){
        Bomb bomb = new Bomb(1, ObjectType.WEAPON);
        bomb.useWeapon(player, x, y);
    }
}
