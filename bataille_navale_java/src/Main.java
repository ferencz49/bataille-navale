//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.map.Grid;
import bataille_navale.views.GameSettings;

public class Main {
    public static void main(String[] args){

        Grid playerGrid = new Grid(10, 10);
        Grid computerGrid = new Grid(10, 10);
        HumanPlayer player = new HumanPlayer(playerGrid, computerGrid);
        Computer computerPlayer = new Computer(computerGrid, playerGrid);

        GameSettings g = new GameSettings(playerGrid,computerGrid, player, computerPlayer);
    }
}
