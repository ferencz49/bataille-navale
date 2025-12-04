package bataille_navale.views;

import bataille_navale.models.GridObserver;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.items.traps.Trap;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class afficherGrille extends JFrame implements GridObserver {

    private JLabel batailleNavale;
    private JButton[][] afficheGrille;
    private JButton[][] afficheGrille2;
    private Grid grid;
    private Grid grid2;

    public afficherGrille(Grid g1 ,Grid g2) {

        this.grid = g1;
        this.grid2 = g2;

        grid.addObserver(this);
        grid2.addObserver(this);

        // Boutons
        afficheGrille = createButtonGrid(g1);
        afficheGrille2 = createButtonGrid(g2);

        // Panels
        JPanel panel1 = createGridPanel(afficheGrille);
        JPanel panel2 = createGridPanel(afficheGrille2);

        // Layout final
        setLayout(new GridLayout(1, 2));  // deux grilles côte à côte

        add(panel1);
        add(panel2);

        pack();
        setLocationRelativeTo(null);
        setTitle("Grille");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        update(grid);
        update(grid2);
    }

    @Override
    public void update(Grid grille) {
        if(grille == this.grid){
            updateGrid(this.grid,this.afficheGrille);
        }
        else{
            updateGrid(this.grid2,this.afficheGrille2);
        }

    }

    public void updateGrid(Grid grille, JButton[][]boutons){
        for (int y = 0; y < grille.getGrille().length; y++) {
            for (int x = 0; x < grille.getGrille()[0].length; x++) {

                Object obj = grille.getCase(x, y);

                if (obj == null) boutons[y][x].setBackground(Color.BLUE);
                else if (obj instanceof Boat) boutons[y][x].setBackground(Color.GRAY);
                else if (obj instanceof Trap) boutons[y][x].setBackground(Color.ORANGE);
            }
        }
    }


    private JButton[][] createButtonGrid(Grid grid) {
        int rows = grid.getGrille().length;
        int cols = grid.getGrille()[0].length;

        JButton[][] buttons = new JButton[rows][cols];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));
                buttons[y][x] = btn;
            }
        }

        return buttons;
    }

    private JPanel createGridPanel(JButton[][] buttons) {
        int rows = buttons.length;
        int cols = buttons[0].length;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                panel.add(buttons[y][x]);
            }
        }

        return panel;
    }
}
