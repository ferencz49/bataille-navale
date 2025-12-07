package bataille_navale.controllers.players;

import bataille_navale.models.items.weapons.Bomb;
import bataille_navale.models.map.Grid;

public class HumanPlayer extends Player {
    private Grid playerGrid;
    private Grid enemyGrid;

    public HumanPlayer(Grid playerGrid, Grid ennemyGrid){
        this.playerGrid = playerGrid;
        this.enemyGrid = ennemyGrid;
    }

    public void playerTurn(){
    }

    public void placeBoats(){
        playerGrid.setBoats1();
    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public void basicAttack(int x, int y){
        this.enemyGrid.basicAttack(x, y);
    }

    public void useBomb(int x, int y){
        Bomb bomb = new Bomb(1);
        bomb.useBomb(x,y,this.enemyGrid);
    }
}
