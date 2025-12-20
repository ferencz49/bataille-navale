package bataille_navale.models.map;

import bataille_navale.controllers.players.Player;
import bataille_navale.models.Object;
import bataille_navale.models.Objects.ObjectType;

public class IleTouchee extends Object {

    public IleTouchee(int size, ObjectType objectType){
        super(size, objectType);
    }

    @Override
    public void onHit(Player player, int x, int y) {
        
    }
}
