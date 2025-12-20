package bataille_navale.models.map;

import bataille_navale.models.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

public class BateauCoule extends Object {
    public BateauCoule(int size) {
        super(size, ObjectType.SUNK_BOAT);
    }

    public void onHit(Player player, int x, int y){};

}
