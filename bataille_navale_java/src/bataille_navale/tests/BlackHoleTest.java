package bataille_navale.tests;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.items.traps.BlackHole;
import bataille_navale.models.items.weapons.Bomb;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackHoleTest {

    @Test
    void onHit() {
        Grid grid_player1 = new Grid();
        Grid grid_player2 = new Grid();
        Bomb bomb = new Bomb(1);
        BlackHole blackHole = new BlackHole(1);
        Boat boat = Boat.createTorpilleur(BoatDirection.Horizontal);

        grid_player1.setTrap( 5,5, blackHole);
        grid_player2.setBoat(5,5, boat);

        bomb.useBomb(5,5, grid_player1);

        boolean result = boat.isSunk();
        System.out.println(boat.getHits());
        assertTrue(result);


    }
}