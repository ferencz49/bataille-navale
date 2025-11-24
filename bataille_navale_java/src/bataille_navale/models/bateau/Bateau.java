package bataille_navale.models.bateau;

import bataille_navale.models.Object;

public class Bateau extends Object {
    private int hits;
    private Types type;
    private BoatDirection orientation; //TRUE = VERTICAL ; FALSE = HORIZONTAL

    public Bateau( int size, Types type, BoatDirection direction){
        super(size);
        this.type = type;
        this.orientation = direction;
    }

    public boolean isSunk(){
        return this.getSize() == this.hits;
    }

    public void increaseHits(){
        this.hits++;
    }

    public int getHits(){
        return this.hits;
    }
}
