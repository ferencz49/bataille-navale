package bataille_navale.tests;

import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.boat.Boat;
import bataille_navale.models.Objects.boat.BoatDirection;
import bataille_navale.models.Objects.boat.BoatFactory;
import bataille_navale.models.Objects.items.traps.BlackHole;
import bataille_navale.models.Objects.items.weapons.Bomb;
import bataille_navale.models.map.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackHoleTest {

    @Test
    void onHit() {
        Grid grid_player1 = new Grid();
        Grid grid_player2 = new Grid();
        HumanPlayer playerTest = new HumanPlayer(grid_player1, grid_player2);
        Bomb bomb = new Bomb(1, ObjectType.WEAPON);
        BlackHole blackHole = new BlackHole(1);
        Boat boat = BoatFactory.createTorpilleur(BoatDirection.Horizontal);

        grid_player1.setTrap( 5,5, blackHole);
        grid_player2.setBoat(5,5, boat);

        bomb.useWeapon(playerTest, 5,5);

        boolean result = boat.isSunk();
        System.out.println(boat.getHits());
        assertTrue(result);


    }
}