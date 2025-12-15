package bataille_navale.views;

import bataille_navale.models.GridObserver;
import bataille_navale.models.Objects.items.boat.Boat;
import bataille_navale.models.Objects.items.traps.Trap;
import bataille_navale.models.Objects.weapons.Weapon;
import bataille_navale.models.map.BateauCoule;
import bataille_navale.models.map.CaseAttaquee;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class AfficherGrille extends JFrame implements GridObserver {

    private JLabel grilleJoueur = new JLabel("Votre grille");
    private JLabel grilleOrdinateur = new JLabel("Grille de l'ordinateur");
    private JButton[][] afficheGrille;
    private JButton[][] afficheGrille2;
    private JButton utiliserBombe = new JButton("utiliser votre bombe");
    private JButton utiliserAttaque = new JButton("utiliser votre attaque de base");
    private Grid grid;
    private Grid grid2;

    public AfficherGrille(Grid g1 , Grid g2) {

        this.grid = g1;
        this.grid2 = g2;

        grid.addObserver(this);
        grid2.addObserver(this);

        // Boutons
        afficheGrille = createButtonGrid(g1);
        afficheGrille2 = createButtonGrid(g2);

        // Grille joueur
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        grilleJoueur.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(grilleJoueur,BorderLayout.NORTH);
        panel1.add(createGridPanel(afficheGrille), BorderLayout.CENTER);
        panel1.add(createActionButtons(), BorderLayout.WEST );



        //grille ordinateur
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        grilleOrdinateur.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(grilleOrdinateur, BorderLayout.NORTH);
        panel2.add(createGridPanel(afficheGrille2),BorderLayout.CENTER);




        // Layout final
        setLayout(new GridLayout(1, 2));

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
            updatePlayerGrid(this.grid,this.afficheGrille);
        }
        else{
            updateComputerGrid(this.grid2,this.afficheGrille2);
        }

    }

    public void updatePlayerGrid(Grid grille, JButton[][]boutons){
        for (int y = 0; y < grille.getGrille().length; y++) {
            for (int x = 0; x < grille.getGrille()[0].length; x++) {

                Object obj = grille.getCase(x, y);

                if (obj == null) boutons[y][x].setBackground(Color.BLUE);
                else if (obj instanceof BateauCoule) boutons[y][x].setBackground(Color.red);
                else if (obj instanceof Boat) boutons[y][x].setBackground(Color.GRAY);
                else if (obj instanceof Trap) boutons[y][x].setBackground(Color.ORANGE);
                else if (obj instanceof Weapon) boutons[y][x].setBackground(Color.BLACK);
                else if (obj instanceof CaseAttaquee) boutons[y][x].setBackground(Color.MAGENTA);
            }
        }
    }

    public void updateComputerGrid(Grid grille, JButton[][]boutons){
        for (int y = 0; y < grille.getGrille().length; y++) {
            for (int x = 0; x < grille.getGrille()[0].length; x++) {

                Object obj = grille.getCase(x, y);

                if (obj == null) boutons[y][x].setBackground(Color.BLUE);
                else if (obj instanceof BateauCoule) boutons[y][x].setBackground(Color.red);
                else if (obj instanceof Boat) boutons[y][x].setBackground(Color.BLUE);
                else if (obj instanceof Trap) boutons[y][x].setBackground(Color.ORANGE);
                else if (obj instanceof Weapon) boutons[y][x].setBackground(Color.BLACK);
                else if (obj instanceof CaseAttaquee) boutons[y][x].setBackground(Color.MAGENTA);
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

        String[] chiffres_indice = {"0","1","2","3","4","5","6","7","8","9"};
        String[] lettres_indice = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows + 1, cols + 1));

        // Case vide en haut à gauche
        panel.add(new JLabel(""));

        // Ajouter A B C D ...
        for (int i = 0; i < cols; i++) {
            JLabel label = new JLabel(lettres_indice[i], SwingConstants.CENTER);
            panel.add(label);
        }

        // Ajouter les lignes
        for (int y = 0; y < rows; y++) {
            // Numéro de ligne
            JLabel label = new JLabel(chiffres_indice[y], SwingConstants.CENTER);
            panel.add(label);

            // Boutons
            for (int x = 0; x < cols; x++) {
                panel.add(buttons[y][x]);
            }
        }

        return panel;
    }

    private JPanel createActionButtons(){
        JPanel jpanel= new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));

        utiliserAttaque.setPreferredSize(new Dimension(40,20));

        jpanel.add(utiliserAttaque);
        jpanel.add(utiliserBombe);

        return jpanel;
    }

    public JButton getUtiliserBombe(){
        return this.utiliserBombe;
    }

    public JButton getUtiliserAttaque(){
        return this.utiliserAttaque;
    }

    public JButton[][] getAfficheGrilleEnnemi() { return afficheGrille2; }
}
