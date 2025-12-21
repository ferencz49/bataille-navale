package bataille_navale.models.Objects.items.traps;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.weapons.Bomb;
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
    public void onHit(Player player, int x, int y){
        Grid playerGrid = player.getGrid();

        if (playerGrid.cellExists(x, y)) {
            playerGrid.basicAttack(player, x, y);
        }
    }

}
