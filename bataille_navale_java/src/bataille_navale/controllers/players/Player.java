package bataille_navale.controllers.players;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.map.Grid;

public  abstract class Player {
    private int nbBoats;
    protected Grid playerGrid;
    protected Grid enemyGrid;

    public Player(Grid playerGrid, Grid ennemyGrid){
        this.nbBoats = 5;
        this.playerGrid = playerGrid;
        this.enemyGrid = ennemyGrid;
    }

    public int getNbBoats(){
        return this.nbBoats;
    }

    public Grid getGrid(){
        return this.playerGrid;
    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public void placeBoats(){
        playerGrid.setBoats1();
    }

    abstract public void playerTurn();

    public void removeBoat(Boat boat) {
    }
}
