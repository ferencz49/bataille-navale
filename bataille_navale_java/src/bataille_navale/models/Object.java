package bataille_navale.models;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

public abstract class Object {
    private ObjectType objectType;
    private int size;
    private int[][] squaresOccupied;
    public Object(int size, ObjectType objectType){
        this.size = size;
        this.objectType = objectType;
    }

    public int getSize(){
        return this.size;
    }

    abstract public void onHit(Player player, int x, int y);

    public ObjectType getType(){
        return this.objectType;
    }
}
