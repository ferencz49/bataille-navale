package bataille_navale;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.map.Grid;

public abstract class Object {
    private int size;
    private int[][] squaresOccupied;
    public Object(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    abstract public void onHit(Player player, int x, int y);
}
