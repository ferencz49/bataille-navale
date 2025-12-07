package bataille_navale.models.boat;

import bataille_navale.Object;
import bataille_navale.models.map.Grid;

public class Boat extends Object {
    private int hits;
    private Types type;
    private BoatDirection boatDirection;

    public Boat(int size, Types type, BoatDirection direction){
        super(size);
        this.type = type;
        this.boatDirection = direction;
    }

    public static Boat createPorteAvion(BoatDirection direction){
        return new Boat(5, Types.PorteAvion, direction);
    }

    public static Boat createCroiseur(BoatDirection direction){
        return new Boat(4, Types.Croiseur, direction);
    }

    public static Boat createContreTorpilleur(BoatDirection direction){
        return new Boat(3, Types.ContreTorpilleur, direction);
    }

    public static Boat createSousMarin(BoatDirection direction){
        return new Boat(3, Types.SousMarin, direction);
    }

    public static Boat createTorpilleur(BoatDirection direction){
        return new Boat(2, Types.Torpilleur, direction);
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
    public void onHit(Grid grid, int x, int y){
        this.increaseHits();
        if(this.getHits() == this.getSize()){
            grid.removeObject(x,y,this.boatDirection,this.getSize(),this);
        }
    }

    public int getHits(){
        return this.hits;
    }

    public BoatDirection getBoatDirection(){
        return this.boatDirection;
    }
}
