//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;
import bataille_navale.models.map.Grid;
import bataille_navale.models.items.weapons.Bomb;
import bataille_navale.views.GameSettings;
import bataille_navale.views.afficherGrille;

public class Main {
    public static void main(String[] args) {

        Grid g = new Grid();
        Grid g2 = new Grid();


        afficherGrille a = new afficherGrille(g,g2);

        Boat b = Boat.createContreTorpilleur(BoatDirection.Vertical);
        g.setBoat(5, 5, b);

        Boat b2 = Boat.createPorteAvion(BoatDirection.Horizontal);
        g2.setBoat(2, 2, b2);
    }
}