package bataille_navale.views;

import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.controllers.players.Player;
import bataille_navale.controllers.players.PlayerType;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class GameEnd extends JFrame {
    JButton playAgain;
    JLabel gameResult;

    public GameEnd(HumanPlayer humanPlayer, Computer computerPlayer, Player winner){

        JPanel layout_principal = new JPanel(new BorderLayout());

        this.playAgain = new JButton("Lancer une nouvelle partie");
        playAgain.addActionListener(e->{
            this.dispose();
            GameSettings gameSettings = new GameSettings(new Grid(), new Grid() ,humanPlayer, computerPlayer);
        });
        layout_principal.add(playAgain,BorderLayout.SOUTH);
        System.out.println("ezhfzef"+winner.getType());
        if(winner.getType() == PlayerType.HUMAN){ this.gameResult = new JLabel("Vous avez gagné");}
        else{this.gameResult = new JLabel("avez perdu");}

        layout_principal.add(gameResult,BorderLayout.CENTER);


        add(layout_principal);
        setTitle("Fin de partie");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
