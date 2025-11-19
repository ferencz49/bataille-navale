//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.models.bateau.Bateau;
import bataille_navale.models.bateau.Types;
import bataille_navale.models.grille.Grille;
import bataille_navale.views.GameSettings;

public class Main {
    public static void main(String[] args) {
        //GameSettings a = new GameSettings();

        Grille g = new Grille();

        Bateau b = new Bateau(4, Types.Croiseur, true);

        g.setObject(3, 4, true, 3, b);

        for (int i = 0; i < g.getGrille()[0].length; i++) {
            for (int j = 0; j < g.getGrille()[1].length; j++) {
                if (g.getGrille()[i][j] != null) {
                    System.out.print("x\t");
                } else {
                    System.out.print(g.getGrille()[i][j] + "  ");
                }
            }
            System.out.println();
        }


    }
}