package batailleNavale.models.traps;

public class Tornado extends Trap {
    private boolean canBePlaced = true;

    public Tornado(int size){
        super(size);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }
}
