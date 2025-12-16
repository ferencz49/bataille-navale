package bataille_navale.controllers.players;

import bataille_navale.models.Objects.items.Item;
import bataille_navale.models.Objects.items.boat.Boat;
import bataille_navale.models.Objects.weapons.Bomb;
import bataille_navale.models.map.Grid;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    private ArrayList<Boat> boatsToPlace;
    private ArrayList<Item> usableItems;

    public HumanPlayer(Grid playerGrid, Grid ennemyGrid){
        super(playerGrid, ennemyGrid, PlayerType.HUMAN);
        this.boatsToPlace = new ArrayList<>();
        this.usableItems = new ArrayList<>();
    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public void basicAttack(Player player, int x, int y){
        this.enemyGrid.basicAttack(player, x, y);
    }

    public void useBomb(int x, int y){
        Bomb bomb = new Bomb(1);
        this.enemyGrid.bombAttack(bomb, this, x, y);
    }

    public void playerTurn(){
    }

    public void addBoatToPlace(Boat boat){
        this.boatsToPlace.add(boat);
    }

    public boolean isGridEmpty() {
        for (int i = 0; i < this.getGrid().getWidth(); i++) {
            for (int j = 0; j < this.getGrid().getHeight(); j++) {
                if(this.getGrid().getCase(i,j) != null){
                    return false;
                }
            }
        }
        return true;
    }

    public void addItem(Item item){
        this.usableItems.add(item);
    }
}
