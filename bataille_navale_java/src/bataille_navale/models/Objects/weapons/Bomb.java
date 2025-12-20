package bataille_navale.models.Objects.weapons;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

public class Bomb extends Weapon{

    public Bomb(int capacity, ObjectType objectType){
        super(capacity, objectType);
    }

    public boolean getCanBeThrown() {
        return this.canBeUsed();
    }

    public void useWeapon(Player player, int x, int y){
        player.getEnemyGrid().bombAttack(this,player, x, y);
    }
}
