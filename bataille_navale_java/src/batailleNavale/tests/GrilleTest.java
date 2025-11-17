package batailleNavale.tests;

import batailleNavale.models.bateau.Bateau;
import batailleNavale.models.bateau.Types;
import batailleNavale.models.grille.Grille;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void getGrille() {
    }

    @Test
    void setObject() {
        Bateau b = new Bateau(5, Types.Croiseur, true);
        Grille g = new Grille();

        boolean result = g.setObject(5, 6, b);

        assertTrue(result);           // Vérifie que l'ajout réussit

        //boolean result2 = g.setObject(11,15,b);
        //assertFalse(result);
    }
}