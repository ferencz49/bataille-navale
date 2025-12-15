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

        Grid g = player.getEnemyGrid();

        if(g.getCase(x,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y);
        }
        if(y+1 < g.getHeight() && g.getCase(x,y+1) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y+1);
        }
        if(x+1 < g.getWidth() &&  g.getCase(x+1,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x+1, y);
        }
        if(y-1 >= 0  && g.getCase(x,y-1) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x, y-1);
        }
        if(x-1 >=0 && g.getCase(x-1,y) != null){
            Object o = g.getCase(x,y);
            o.onHit(player, x-1, y);
        }
    }
}
