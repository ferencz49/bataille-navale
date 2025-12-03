package bataille_navale.models.items.traps;

import bataille_navale.models.items.weapons.Bomb;
import bataille_navale.models.map.Grid;

public class BlackHole extends Trap{
    private boolean canBePlaced = true;

    public BlackHole(int capacity){
        super(capacity);
    }

    public boolean getCanBePlaced() {
        return canBePlaced;
    }

    public void setCanBePlaced(boolean canBePlaced) {
        this.canBePlaced = canBePlaced;
    }

    @Override
    public void onHit(Grid grid,  int x, int y){
        Bomb bomb = new Bomb(1);
        bomb.useBomb(x, y , grid);
    }
}
