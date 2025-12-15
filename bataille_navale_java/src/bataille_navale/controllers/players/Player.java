package bataille_navale.controllers.players;

import bataille_navale.models.Objects.items.Item;
import bataille_navale.models.map.Grid;

public  abstract class Player {

    private final PlayerType type;

    protected Grid playerGrid;
    protected Grid enemyGrid;

    public Player(Grid playerGrid, Grid ennemyGrid, PlayerType playerType){
        this.playerGrid = playerGrid;
        this.enemyGrid = ennemyGrid;
        this.type = playerType;
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


    public void placeBoats(){
        playerGrid.setBoats1();
    }

   public void playerTurn(){}

    public void addItem(Item item){}


}
