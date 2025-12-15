package bataille_navale.models.Objects.island;

import bataille_navale.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.items.Item;

public class Island extends Object {
    private Item item;

    public Island(int size, Item item){
        super(size);
        this.item = item;
    }

    public Island(int size){
        super(size);
    }

    @Override
    public void onHit(Player player, int x, int y) {
        if (this.item != null) {
            player.addItem(item);
        }
    }
}
