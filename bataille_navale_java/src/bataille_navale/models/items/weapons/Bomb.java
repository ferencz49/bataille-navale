package bataille_navale.models.items.weapons;

import bataille_navale.models.bateau.Bateau;
import bataille_navale.models.grille.Grille;

public class Bomb extends Weapon{
    private boolean canBeThrown = true;

    public Bomb(int size, int capacity){
        super(size, capacity);
    }

    public boolean getCanBeThrown() {
        return canBeThrown;
    }

    public void setCanBeThrown(boolean canBeThrown) {
        this.canBeThrown = canBeThrown;
    }

    public void useBomb(int x, int y, Grille g){
        if(g.getCase(x,y) != null){
            Bateau b = (Bateau) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x,y+1) != null){
            Bateau b = (Bateau) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x+1,y) != null){
            Bateau b = (Bateau) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x,y-1) != null){
            Bateau b = (Bateau) g.getCase(x,y);
            b.increaseHits();
        }
        if(g.getCase(x-1,y) != null){
            Bateau b = (Bateau) g.getCase(x,y);
            b.increaseHits();
        }


    }
}
