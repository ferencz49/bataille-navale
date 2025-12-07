package bataille_navale.controllers.players;

import bataille_navale.models.map.Grid;

public class HumanPlayer {
    private Grid playerGrid;
    private Grid ennemyGrid;

    public HumanPlayer(Grid playerGrid, Grid ennemyGrid){
        this.playerGrid = playerGrid;
        this.ennemyGrid = ennemyGrid;
    }

    public void playerTurn(){
    }

    public void placeBoats(){
        playerGrid.setBoats1();
    }
}
