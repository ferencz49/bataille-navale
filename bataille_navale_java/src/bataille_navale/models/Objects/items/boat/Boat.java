package bataille_navale.models.Objects.items.boat;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

import java.util.ArrayList;

public class Boat extends Object {
    private int hits;
    private Types type;
    private BoatDirection boatDirection;
    private ArrayList<BoatCoordinates> coordinates;

    public Boat(int size, Types type, BoatDirection direction){
        super(size, ObjectType.BOAT);
        this.type = type;
        this.boatDirection = direction;
        this.coordinates = new ArrayList<>();
    }

    public int getBoatSize()
    {
        return this.getSize();
    }

    public boolean isSunk(){
        return this.getSize() == this.hits;
    }

    public void increaseHits(){
        this.hits++;
    }

    @Override
    public void onHit(Player player, int x, int y){
        this.increaseHits();
        if(this.getHits() == this.getSize()){
            player.getEnemyGrid().removeBoat(this);
            player.getEnemyGrid().addNbBoatsSunk(1);
        }
    }

    public int getHits(){
        return this.hits;
    }

    public BoatDirection getBoatDirection(){
        return this.boatDirection;
    }

    public ArrayList<BoatCoordinates> getBoatCoordinates(){
        return this.coordinates;
    }

    public void setBoatCoordinates(int x, int y){
        this.coordinates.add(new BoatCoordinates(x,y));
    }
}
