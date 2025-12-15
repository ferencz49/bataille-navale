package bataille_navale.models.map;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;

public class CaseAttaquee extends Object {
    public CaseAttaquee(int size) {
        super(size);
    }

    public void onHit(Player player, int x, int y){};

}
