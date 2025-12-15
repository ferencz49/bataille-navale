package bataille_navale.tests;

import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.Objects.items.boat.Boat;
import bataille_navale.models.Objects.items.boat.BoatDirection;
import bataille_navale.models.Objects.items.boat.Types;
import bataille_navale.models.Objects.weapons.Sonar;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

class SonarTest {

    @Test
    void useSonar() {
        Grid grid_player1 = new Grid();
        Grid grid_player2 = new Grid();
        HumanPlayer playerTest = new HumanPlayer(grid_player1, grid_player2);
        Grid g = new Grid();
        Boat b  = new Boat(3, Types.Croiseur, BoatDirection.Horizontal);
        g.setBoat(5,5, b );

        Sonar s = new Sonar(1);
        s.useWeapon(playerTest, 7,5);
        //assertEquals(2,result);
    }
}