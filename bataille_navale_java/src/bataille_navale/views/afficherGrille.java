package bataille_navale.views;

import bataille_navale.models.Observer;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.items.traps.Trap;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class afficherGrille extends JFrame implements Observer {

    private JLabel batailleNavale;
    private JButton[][] afficheGrille;
    private Grid grid;

    public afficherGrille(Grid grid) {
        grid.addObserver(this);
        this.grid = grid;

        Object[][] grille = grid.getGrille();
        int rows = grille.length;
        int cols = grille[0].length;

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));

        afficheGrille = new JButton[rows][cols];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {

                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));

                afficheGrille[y][x] = btn;
                gridPanel.add(btn);
            }
        }

        add(gridPanel);

        pack();
        setLocationRelativeTo(null);
        setTitle("Grille");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        for (int y = 0; y < grid.getGrille().length; y++) {
            for (int x = 0; x < grid.getGrille()[0].length; x++) {

                Object obj = grid.getCase(x, y);

                if (obj == null) afficheGrille[y][x].setBackground(Color.BLUE);
                else if (obj instanceof Boat) afficheGrille[y][x].setBackground(Color.GRAY);
                else if (obj instanceof Trap) afficheGrille[y][x].setBackground(Color.ORANGE);
            }
        }
    }
}
