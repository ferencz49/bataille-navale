package bataille_navale.tests;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.BoatFactory;
import bataille_navale.models.boat.Types;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void getGrille() {
    }

    @Test
    void setBoat() {
        Boat b = BoatFactory.createCroiseur(BoatDirection.Vertical);
        Grid g = new Grid();

        boolean result = g.setBoat(5, 6, b);

        assertTrue(result);           // Vérifie que l'ajout réussit

        boolean result2 = g.setBoat(11,15,b);
        assertFalse(result2);         // vérifie que l'ajout rate

        boolean result3  = g.setBoat(-1,15,b);
        assertFalse(result3);         // vérifie que l'ajout rate aussi

        boolean result4 = g.setBoat(3,3,b);
        assertTrue(result4);          // vérifie que l'ajoute réussit
    }
}
