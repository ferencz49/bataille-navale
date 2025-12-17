package bataille_navale.controllers.players;

import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.Item;
import bataille_navale.models.Objects.weapons.Bomb;
import bataille_navale.models.Objects.weapons.Sonar;
import bataille_navale.models.map.Grid;

import java.util.ArrayList;

public  abstract class Player {

    private final PlayerType type;
    private ArrayList<Item> usableItems;


    protected Grid playerGrid;
    protected Grid enemyGrid;

    public Player(Grid playerGrid, Grid ennemyGrid, PlayerType playerType){
        this.playerGrid = playerGrid;
        this.enemyGrid = ennemyGrid;
        this.type = playerType;

        this.usableItems = new ArrayList<>();
        this.usableItems.add(new Bomb(1, ObjectType.WEAPON));
        this.usableItems.add(new Sonar(1, ObjectType.SONAR));
    }

    public Grid getGrid(){
        return this.playerGrid;
    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public PlayerType getType(){
        return this.type;
    }

    public ArrayList<Item> getUsableItems(){
        return this.usableItems;
    }


    public void placeBoats(){
        playerGrid.setBoats1();
    }

   public void playerTurn(){}

    public void addItem(Item item){
        this.usableItems.add(item);
    }


}
