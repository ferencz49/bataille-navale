package batailleNavale.models.traps;

public class BlackHole extends Trap{
    private boolean canBePlaced = true;

    public BlackHole(int size){
        super(size);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }
}
