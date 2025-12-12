package bataille_navale.controllers.players;

import bataille_navale.models.map.Grid;
import java.util.Random;


public class Computer extends Player{

    public Computer(Grid computerGrid, Grid ennemyGrid){
        super(computerGrid, ennemyGrid);
    }

    public void playerTurn(Player player){
        this.basicAttack(player);
    }

    public void basicAttack(Player player){
        Random rand = new Random();
        int x = rand.nextInt(9);
        int y = rand.nextInt(9);
        this.enemyGrid.basicAttack(player, x, y);
        System.out.println("le pc a attaqué");
    }


}
