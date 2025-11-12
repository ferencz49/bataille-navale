package batailleNavale.models.bateau;

import batailleNavale.models.Object;

public class Bateau extends Object {
    private int size;
    private int hits;

    public Bateau(int x, int y){
        super(x,y);
    }

    public boolean isSunk(){
        return this.size == this.hits;
    }
}
