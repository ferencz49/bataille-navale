//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;
import bataille_navale.models.map.Grid;
import bataille_navale.models.items.weapons.Bomb;

public class Main {
    public static void main(String[] args) {
        //GameSettings a = new GameSettings();

        Grid g = new Grid();

        Boat b = new Boat(2, Types.Croiseur);

        g.setObject(5, 5, BoatDirection.Vertical, b);

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

        Bomb bomb = new Bomb(1, 1);
        bomb.useBomb(5,5, g);
        System.out.println(b.getHits());

        System.out.println(b.isSunk());

        g.removeObject(5,5, BoatDirection.Vertical, 2, b);

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