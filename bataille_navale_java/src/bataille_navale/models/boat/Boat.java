package bataille_navale.models.boat;

import bataille_navale.Object;

public class Boat extends Object {
    private int hits;
    private Types type;

    public Boat(int size, Types type){
        super(size);
        this.type = type;
    }

    public static Boat createPorteAvion(){
        return new Boat(5, Types.PorteAvion);
    }

    public static Boat createCroiseur(){
        return new Boat(4, Types.Croiseur);
    }

    public static Boat createContreTorpilleur(){
        return new Boat(3, Types.ContreTorpilleur);
    }

    public static Boat createSousMarin(){
        return new Boat(3, Types.SousMarin);
    }

    public static Boat createTorpilleur(){
        return new Boat(2, Types.Torpilleur);
    }

    public int getSize()
    {
        return this.getSize();
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
