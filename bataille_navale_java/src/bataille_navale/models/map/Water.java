package bataille_navale.models.map;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

public class Water extends Object {
    public Water(int size){
        super(size, ObjectType.WATER);
    }

    @Override
    public void onHit(Player player, int x, int y) {

    }


}
