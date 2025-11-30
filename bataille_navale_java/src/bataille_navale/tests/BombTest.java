package bataille_navale.tests;

import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;
import bataille_navale.models.map.Grid;
import bataille_navale.models.items.weapons.Bomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BombTest {

    @Test
    void getCanBeThrown() {
        Bomb b = new Bomb(1,3);

        boolean result = b.getCanBeThrown();
        assertTrue(result);

        Bomb b2 = new Bomb(1,0);

        boolean result2 = b2.getCanBeThrown();
        assertFalse(result2);

    }


    @Test
    void useBomb() {

        //Dans ce test le bateau est touché 2 fois par la bombe, sa taille est 3 donc il n'est pas coulé
        Grid g = new Grid();

        Boat bateau = Boat.createContreTorpilleur(BoatDirection.Horizontal);

        Bomb bomb = new Bomb(1, 1);

        g.setBoat(5,5, bateau);

        bomb.useBomb(5,5, g);

        boolean result = bateau.isSunk();
        System.out.println(bateau.getHits());
        assertFalse(result);
    }
}