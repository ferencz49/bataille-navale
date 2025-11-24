package bataille_navale.models.items.traps;

public class BlackHole extends Trap{
    private boolean canBePlaced = true;

    public BlackHole(int size, int capacity){
        super(size, capacity);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }
}
