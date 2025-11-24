package bataille_navale.models.items.weapons;

public class Sonar extends Weapon{
    private boolean canBeUsed = true;
    private boolean submarineIsAlive = true;

    public Sonar(int size, int capacity){
        super(size, capacity);
    }

    public boolean getCanBeUsed() {
        return canBeUsed;
    }

    public void setCanBeUsed(boolean canBeUsed) {
        this.canBeUsed = canBeUsed;
    }

    public boolean getSubmarineIsAlive() {
        return submarineIsAlive;
    }

    public void setSubmarineIsAlive(boolean submarineIsAlive) {
        this.submarineIsAlive = submarineIsAlive;
    }
}
