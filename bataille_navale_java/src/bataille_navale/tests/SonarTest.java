package bataille_navale.tests;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;
import bataille_navale.models.items.weapons.Sonar;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SonarTest {

    @Test
    void useSonar() {
        Grid g = new Grid();
        Boat b  = new Boat(3, Types.Croiseur);
        g.setObject(5,5, BoatDirection.Horizontal, b );

        Sonar s = new Sonar(1, 1);
        int result = s.useSonar(7,5, g);
        assertEquals(2,result);
    }
}