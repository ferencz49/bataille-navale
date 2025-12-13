package bataille_navale.controllers.players;

import bataille_navale.models.map.Grid;

import java.util.ArrayList;
import java.util.Random;



public class Computer extends Player{

    public Computer(Grid computerGrid, Grid ennemyGrid){
        super(computerGrid, ennemyGrid, PlayerType.COMPUTER);
    }

    public int[] playerTurn(Player player){
        return this.basicAttack(player);
    }

    public int[] basicAttack(Player player){
        Random rand = new Random();
        int x = rand.nextInt(9);
        int y = rand.nextInt(9);
        this.enemyGrid.basicAttack(player, x, y);
        System.out.println("le pc a attaqué");
        int[] res = {x,y};
        return res;
    }


}
