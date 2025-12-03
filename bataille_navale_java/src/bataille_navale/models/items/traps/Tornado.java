package bataille_navale.models.items.traps;

public class Tornado extends Trap {
    private boolean canBePlaced = true;

    public Tornado(int capacity){
        super(capacity);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }
}
