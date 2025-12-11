package bataille_navale.models.map;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;

public class BateauCoule extends Object {
    public BateauCoule(int size) {
        super(size);
    }

    public void onHit(Player player, int x, int y){};

}
