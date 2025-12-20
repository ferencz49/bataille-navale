package bataille_navale.models.map;

import bataille_navale.models.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

public class CaseAttaquee extends Object {
    public CaseAttaquee(int size) {
        super(size, ObjectType.HIT_BOAT);
    }

    public void onHit(Player player, int x, int y){};

}
