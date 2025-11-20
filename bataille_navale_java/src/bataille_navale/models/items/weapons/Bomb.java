package bataille_navale.models.items.weapons;

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
}
