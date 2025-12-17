package bataille_navale.tests;

import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.items.boat.Boat;
import bataille_navale.models.Objects.items.boat.BoatDirection;
import bataille_navale.models.Objects.items.boat.BoatFactory;
import bataille_navale.models.map.Grid;
import bataille_navale.models.Objects.weapons.Bomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BombTest {

    @Test
    void getCanBeThrown() {
        Bomb b = new Bomb(3, ObjectType.WEAPON);

        boolean result = b.getCanBeThrown();
        assertTrue(result);

        Bomb b2 = new Bomb(0, ObjectType.WEAPON);

        boolean result2 = b2.getCanBeThrown();
        assertFalse(result2);

    }


    @Test
    void useBomb() {

        //Dans ce test le bateau est touché 2 fois par la bombe, sa taille est 3 donc il n'est pas coulé
        Grid grid_player1 = new Grid();
        Grid grid_player2 = new Grid();
        HumanPlayer playerTest = new HumanPlayer(grid_player1, grid_player2);

        Boat bateau = BoatFactory.createContreTorpilleur(BoatDirection.Horizontal);

        Bomb bomb = new Bomb(1, ObjectType.WEAPON);

        grid_player1.setBoat(5,5, bateau);

        playerTest.useBomb(5,5);

        boolean result = bateau.isSunk();
        System.out.println(bateau.getHits());
        assertFalse(result);
    }
}