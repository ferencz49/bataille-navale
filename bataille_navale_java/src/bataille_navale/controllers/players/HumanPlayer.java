package bataille_navale.controllers.players;

import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.boat.Boat;
import bataille_navale.models.Objects.weapons.Bomb;
import bataille_navale.models.Objects.weapons.Sonar;
import bataille_navale.models.map.Grid;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    private ArrayList<Boat> boatsToPlace;

    public HumanPlayer(Grid playerGrid, Grid ennemyGrid){
        super(playerGrid, ennemyGrid, PlayerType.HUMAN);
        this.boatsToPlace = new ArrayList<>();

    }

    public Grid getEnemyGrid(){
        return this.enemyGrid;
    }

    public void basicAttack(Player player, int x, int y){
        this.enemyGrid.basicAttack(player, x, y);
    }

    public void useBomb(int x, int y){
        if(this.getUsableItems().isEmpty()){
            return;
        }
        for(int i = 0; i < this.getUsableItems().size();i++){
            if(this.getUsableItems().get(i).getType() == ObjectType.WEAPON){
                this.enemyGrid.bombAttack((Bomb)this.getUsableItems().get(i), this, x, y);
                this.getUsableItems().remove(i);
                return;
            }
        }
    }

    public int useSonar(int x, int y){
        if(this.getUsableItems().isEmpty()){
            return -1;
        }
        int result = 0;
        for(int i = 0; i < this.getUsableItems().size();i++){
            if(this.getUsableItems().get(i).getType() == ObjectType.SONAR){
                result = this.enemyGrid.sonarAttack((Sonar) this.getUsableItems().get(i), this, x, y);
                this.getUsableItems().remove(i);
                return result;
            }
        }
        return -1;
    }

    public void playerTurn(){
    }

    public void addBoatToPlace(Boat boat){
        this.boatsToPlace.add(boat);
    }

    public boolean isGridEmpty() {
        for (int i = 0; i < this.getGrid().getWidth(); i++) {
            for (int j = 0; j < this.getGrid().getHeight(); j++) {
                if(this.getGrid().getCase(i,j) != null){
                    return false;
                }
            }
        }
        return true;
    }
}
