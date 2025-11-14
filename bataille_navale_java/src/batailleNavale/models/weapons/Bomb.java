package batailleNavale.models.weapons;

public class Bomb extends Weapon{
    private boolean canBeThrown = true;

    public Bomb(int size){
        super(size);
    }

    public boolean setCanBeThrown() {
        return canBeThrown;
    }

    public void setCanBeThrown(boolean canBeThrown) {
        this.canBeThrown = canBeThrown;
    }
}
