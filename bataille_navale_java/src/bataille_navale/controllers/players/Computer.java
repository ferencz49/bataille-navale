package bataille_navale.controllers.players;

import bataille_navale.Object;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.boat.Boat;
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
            int x = rand.nextInt(enemyGrid.getWidth());
            int y = rand.nextInt(enemyGrid.getHeight());
            if(enemyGrid.getCase(x,y) == null){
                enemyGrid.basicAttack(player, x, y);
                return new int[]{x,y};
            }

            Object obj = enemyGrid.getCase(x, y);

            if (obj.getType() == ObjectType.HIT_BOAT || obj.getType() == ObjectType.SUNK_BOAT || obj.getType() == ObjectType.WATER) {
                return basicAttack(player);
            }

            enemyGrid.basicAttack(player, x, y);
            return new int[]{x, y};
    }


}
