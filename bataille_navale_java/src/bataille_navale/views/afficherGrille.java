package bataille_navale.views;

import javax.swing.*;

public class afficherGrille extends JFrame {

    public JPanel Settings;
    private JLabel batailleNavale;
    private JLabel Grille;

    public afficherGrille() {
        setTitle("Grille");
        setSize(1280, 720);
        setVisible(true);
        setContentPane(Settings);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
