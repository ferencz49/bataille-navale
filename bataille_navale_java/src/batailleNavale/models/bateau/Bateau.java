package batailleNavale.models.bateau;

import batailleNavale.models.Object;

import java.lang.reflect.Type;

public class Bateau extends Object {
    private int size;
    private int hits;
    private Types type;

    public Bateau( int size, Types type){
        super(size);
        this.type = type;
    }

    public boolean isSunk(){
        return this.size == this.hits;
    }
}
