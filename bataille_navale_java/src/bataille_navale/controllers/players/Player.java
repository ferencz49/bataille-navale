package bataille_navale.controllers.players;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.map.Grid;

public  abstract class Player {
    private int nbBoats;
    private int nbBoatsSunk;
    private PlayerType type;

    protected Grid playerGrid;
    protected Grid enemyGrid;

    public Player(Grid playerGrid, Grid ennemyGrid, PlayerType playerType){
        this.nbBoats = 0;
        this.nbBoatsSunk = 0;
        this.playerGrid = playerGrid;
        this.enemyGrid = ennemyGrid;
        this.type = playerType;
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

    public PlayerType getType(){
        return this.type;
    }

    public void addNbBoatsSunk(int nb){
        this.nbBoatsSunk+= nb;
    }

    public void placeBoats(){
        playerGrid.setBoats1();
        this.nbBoats+=3;
    }

   public void playerTurn(){}

    public boolean allBoatsSunk(){
        return this.nbBoats == this.nbBoatsSunk;
    }

}
