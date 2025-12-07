package bataille_navale.controllers.players;

import bataille_navale.models.map.Grid;

public class Computer {
    private Grid computerGrid;
    private Grid ennemyGrid;

    public Computer(Grid computerGrid, Grid ennemyGrid){
        this.computerGrid = computerGrid;
        this.ennemyGrid = ennemyGrid;
    }

    public void computerTurn(){
    }

    public void placeBoats(){
        computerGrid.setBoats1();
    }
}
