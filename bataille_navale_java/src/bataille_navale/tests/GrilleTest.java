package bataille_navale.tests;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void getGrille() {
    }

    @Test
    void setObject() {
        Boat b = Boat.createCroiseur();
        Grid g = new Grid();

        boolean result = g.setObject(5, 6,BoatDirection.Vertical, b);

        assertTrue(result);           // Vérifie que l'ajout réussit

        boolean result2 = g.setObject(11,15,BoatDirection.Vertical,b);
        assertFalse(result2);         // vérifie que l'ajout rate

        boolean result3  = g.setObject(-1,15,BoatDirection.Vertical,b);
        assertFalse(result3);         // vérifie que l'ajout rate aussi

        boolean result4 = g.setObject(3,3, BoatDirection.Vertical,b);
        assertTrue(result4);          // vérifie que l'ajoute réussit
    }
}
