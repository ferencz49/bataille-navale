package bataille_navale.models.Objects.island;

import bataille_navale.models.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.Item;
import bataille_navale.models.map.IleTouchee;

public class Island extends Object {
    private Item item;

    public Island(int size, Item item){
        super(size, ObjectType.ISLAND);
        this.item = item;
    }

    public Island(int size){
        super(size,ObjectType.ISLAND);
    }

    @Override
    public void onHit(Player player, int x, int y) {
        if (this.item != null) {
            player.addItem(item);
            this.item = null;
        }
    }
}
