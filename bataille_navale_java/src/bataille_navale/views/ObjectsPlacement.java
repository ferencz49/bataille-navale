package bataille_navale.views;

import bataille_navale.controllers.gameController.GameController;
import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class ObjectsPlacement extends JFrame {
    private HumanPlayer humanPlayer;
    private Computer computerPlayer;
    private JLabel grilleJoueur;
    private JButton[][] afficheGrille;
    private JButton lancerPartie;
    private Grid grid;



    public ObjectsPlacement(Grid playerGrid, Grid computerGrid, HumanPlayer humanPlayer, Computer computerPlayer){
        //on initialise les attributs
        this.grid = playerGrid;
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;

        //Panels, boutons etc.
        grilleJoueur = new JLabel("Placez vos bateaux sur votre grille");
        JPanel layout_principal = new JPanel(new BorderLayout());
        layout_principal.add(grilleJoueur, BorderLayout.NORTH);
        afficheGrille = createButtonGrid();
        layout_principal.add(createGridPanel(afficheGrille), BorderLayout.CENTER);
        lancerPartie = new JButton("Lancer la partie");
        lancerPartie.addActionListener(e-> {
            GameController controller = new GameController( new AfficherGrille(playerGrid,computerGrid), humanPlayer, computerPlayer);
            if(humanPlayer.isGridEmpty()){
                computerPlayer.placeBoats();
                humanPlayer.placeBoats();
                computerPlayer.placeIsland();
                humanPlayer.placeIsland();
            }
            this.dispose();
        });
        layout_principal.add(lancerPartie, BorderLayout.SOUTH);

        //trucs communs à toutes les vues
        add(layout_principal);
        setTitle("Placement des objets");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private JButton[][] createButtonGrid() {
        int rows = this.grid.getGrille().length;
        int cols = this.grid.getGrille()[0].length;

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
        panel.setLayout(new GridLayout(rows+1, cols+1));

        for(int i = 0; i < cols; i++){
            JLabel label= new JLabel(lettres_indice[i], SwingConstants.CENTER);
            panel.add(label);
        }

        for (int y = 0; y < rows; y++) {
            JLabel label = new JLabel(chiffres_indice[y], SwingConstants.CENTER);
            panel.add(label);
            for (int x = 0; x < cols; x++) {
                panel.add(buttons[y][x]);
            }
        }

        return panel;
    }
}
