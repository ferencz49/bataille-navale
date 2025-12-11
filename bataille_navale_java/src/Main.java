//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.controllers.gameController.GameController;
import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.BoatFactory;
import bataille_navale.models.items.traps.Tornado;
import bataille_navale.models.map.Grid;
import bataille_navale.views.AfficherGrille;
import bataille_navale.views.GameSettings;
import bataille_navale.views.ObjectsPlacement;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // --- Initialisation des données de test ---
        // Grille du joueur + grille ennemie
        Grid playerGrid = new Grid(10, 10);
        Grid computerGrid = new Grid(10, 10);
        HumanPlayer player = new HumanPlayer(playerGrid, computerGrid);
        Computer computerPlayer = new Computer(computerGrid, playerGrid);

        GameSettings g = new GameSettings(playerGrid,computerGrid, player);
    }
}
