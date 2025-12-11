package bataille_navale.models.items.weapons;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.map.Grid;

public class Bomb extends Weapon{

    public Bomb(int capacity){
        super(capacity);
    }

    public boolean getCanBeThrown() {
        return this.canBeUsed();
    }

    public void useWeapon(Player player, int x, int y){

        Grid g = player.getGrid();

        if(g.getCase(x,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y);
        }
        if(g.getCase(x,y+1) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y+1);
        }
        if(g.getCase(x+1,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x+1, y);
        }
        if(g.getCase(x,y-1) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y-1);
        }
        if(g.getCase(x-1,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x-1, y);
        }
    }
}
