package bataille_navale.models.bateau;

import bataille_navale.models.Object;

public class Bateau extends Object {
    private int size;
    private int hits;
    private Types type;
    private boolean orientation; //TRUE = VERTICAL ; FALSE = HORIZONTAL

    public Bateau( int size, Types type, boolean orientation){
        super(size);
        this.type = type;
        this.orientation = orientation;
    }

    public boolean isSunk(){
        return this.size == this.hits;
    }
}
