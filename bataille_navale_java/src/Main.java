//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.controllers.gameController.GameController;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
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
        Grid enemyGrid = new Grid(10, 10);

        Boat b = Boat.createContreTorpilleur(BoatDirection.Vertical);
        enemyGrid.setBoat(1,1,b);

        Boat b2 = Boat.createSousMarin(BoatDirection.Horizontal);
        enemyGrid.setBoat(5,5,b2);

        // Créer un HumanPlayer avec sa grille + grille ennemie
        HumanPlayer human = new HumanPlayer(playerGrid, enemyGrid);

        // --- Création de la vue principale ---
        AfficherGrille view = new AfficherGrille(playerGrid, enemyGrid);

        // --- Lier le contrôleur ---
        GameController controller = new GameController(view, human);

        while(1 == 1 )
            System.out.println(b2.getHits());
    }
}
