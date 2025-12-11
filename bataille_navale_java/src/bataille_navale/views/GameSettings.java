package bataille_navale.views;


import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {



    public GameSettings(Grid playerGrid, Grid computerGrid, HumanPlayer humanPlayer){
        JButton btn_fin_config = new JButton("Passer au placement des objets");
        btn_fin_config.addActionListener(e -> {
            new ObjectsPlacement(playerGrid, computerGrid, humanPlayer);
            this.dispose();
        });

        JCheckBox ckb_mode_ile = new JCheckBox("mode ile");
        JLabel lbl_nb_porte_avions = new JLabel("Nombre de porte avions:");
        JSpinner spn_nb_porte_avions = new JSpinner();
        JLabel lbl_nb_croiseurs = new JLabel("Nombre de croiseurs:");
        JSpinner spn_nb_croiseurs = new JSpinner();
        JLabel lbl_nb_contre_torpilleurs = new JLabel("Nombre de contre torpilleurs:");
        JSpinner spn_nb_contre_torpilleurs = new JSpinner();
        JLabel lbl_nb_sous_marins = new JLabel("Nombre de sous-marins:");
        JSpinner spn_nb_sous_marins = new JSpinner();
        JLabel lbl_nb_torpilleurs = new JLabel("Nombre de torpilleurs:");
        JSpinner spn_nb_torpilleurs = new JSpinner();

        JPanel layout_principal = new JPanel(new BorderLayout());
        layout_principal.add(btn_fin_config, BorderLayout.SOUTH);

        JPanel layout_secondaire_centre = new JPanel();
        layout_secondaire_centre.setLayout(new BoxLayout(layout_secondaire_centre, BoxLayout.Y_AXIS));
        layout_secondaire_centre.add(Box.createVerticalStrut(20));
        layout_secondaire_centre.setBorder(BorderFactory.createEmptyBorder(100, 300, 100, 300));
        layout_secondaire_centre.add(ckb_mode_ile);
        layout_secondaire_centre.add(lbl_nb_porte_avions);
        layout_secondaire_centre.add(spn_nb_porte_avions);
        layout_secondaire_centre.add(lbl_nb_croiseurs);
        layout_secondaire_centre.add(spn_nb_croiseurs);
        layout_secondaire_centre.add(lbl_nb_contre_torpilleurs);
        layout_secondaire_centre.add(spn_nb_contre_torpilleurs);
        layout_secondaire_centre.add(lbl_nb_sous_marins);
        layout_secondaire_centre.add(spn_nb_sous_marins);
        layout_secondaire_centre.add(lbl_nb_torpilleurs);
        layout_secondaire_centre.add(spn_nb_torpilleurs);
        //on ajoute le layout qui contient les boutons permettant de setup la game au centre du layout principal
        layout_principal.add(layout_secondaire_centre, BorderLayout.CENTER);



        add(layout_principal);

        setTitle("Paramètres de la partie");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
