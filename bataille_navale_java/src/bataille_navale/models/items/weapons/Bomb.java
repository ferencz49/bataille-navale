package bataille_navale.models.items.weapons;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.map.Grid;

public class Bomb extends Weapon{

    public Bomb(int size, int capacity){
        super(size, capacity);
    }

    public boolean getCanBeThrown() {
        return this.canBeUsed();
    }



    public void useBomb(int x, int y, Grid g){
        if(g.getCase(x,y) != null){
            Boat b = (Boat) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x,y+1) != null){
            Boat b = (Boat) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x+1,y) != null){
            Boat b = (Boat) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x,y-1) != null){
            Boat b = (Boat) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x-1,y) != null){
            Boat b = (Boat) g.getCase(x,y);
            b.increaseHits();
        }


    }
}
