package bataille_navale.views;

import javax.swing.*;
import java.awt.*;

public class GameEnd extends JFrame {
    JButton playAgain;
    JLabel gameResult;
    public GameEnd(){

        JPanel layout_principal = new JPanel(new BorderLayout());

        this.playAgain = new JButton("Lancer une nouvelle partie");
        layout_principal.add(playAgain,BorderLayout.SOUTH);

        this.gameResult = new JLabel("ici y'aura le gagnant");
        layout_principal.add(gameResult,BorderLayout.CENTER);


        add(layout_principal);
        setTitle("Fin de partie");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
