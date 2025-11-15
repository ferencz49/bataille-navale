package batailleNavale.views;

import javax.swing.*;

public class GameSettings extends JFrame{
    public JPanel Settings;
    private JLabel batailleNavale;
    private JLabel Grille;

    public GameSettings(){
        setTitle("Settings");
        setSize(1280,720);
        setVisible(true);
        setContentPane(Settings);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
