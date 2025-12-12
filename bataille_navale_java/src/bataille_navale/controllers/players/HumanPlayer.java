package bataille_navale.controllers.players;

import bataille_navale.models.items.weapons.Bomb;
import bataille_navale.models.map.Grid;

public class HumanPlayer extends Player {

    public HumanPlayer(Grid playerGrid, Grid ennemyGrid){
        super(playerGrid, ennemyGrid, PlayerType.HUMAN);
    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public void basicAttack(Player player, int x, int y){
        this.enemyGrid.basicAttack(player, x, y);
    }

    public void useBomb(int x, int y){
        Bomb bomb = new Bomb(1);
        bomb.useWeapon(this ,x,y);
    }

    public void playerTurn(){
    }
}
