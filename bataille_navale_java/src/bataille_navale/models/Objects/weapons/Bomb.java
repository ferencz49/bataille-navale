package bataille_navale.models.Objects.weapons;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.map.Grid;

public class Bomb extends Weapon{

    public Bomb(int capacity){
        super(capacity);
    }

    public boolean getCanBeThrown() {
        return this.canBeUsed();
    }

    public void useWeapon(Player player, int x, int y){
        player.getEnemyGrid().bombAttack(this,player, x, y);
    }
}
