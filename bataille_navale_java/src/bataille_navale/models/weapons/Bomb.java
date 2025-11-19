package bataille_navale.models.weapons;

public class Bomb extends Weapon{
    private boolean canBeThrown = true;

    public Bomb(int size){
        super(size);
    }

    public boolean getCanBeThrown() {
        return canBeThrown;
    }

    public void setCanBeThrown(boolean canBeThrown) {
        this.canBeThrown = canBeThrown;
    }
}
