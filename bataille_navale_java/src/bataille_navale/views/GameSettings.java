package bataille_navale.views;


import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.models.Objects.items.boat.BoatDirection;
import bataille_navale.models.Objects.items.boat.BoatFactory;
import bataille_navale.models.map.Grid;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {
    JButton btn_fin_config;

    JCheckBox ckb_mode_ile;
    JLabel lbl_nb_porte_avions;
    JSpinner spn_nb_porte_avions;
    JLabel lbl_nb_croiseurs;
    JSpinner spn_nb_croiseurs;
    JLabel lbl_nb_contre_torpilleurs;
    JSpinner spn_nb_contre_torpilleurs;
    JLabel lbl_nb_sous_marins;
    JSpinner spn_nb_sous_marins;
    JLabel lbl_nb_torpilleurs;
    JSpinner spn_nb_torpilleurs;



    public GameSettings(Grid playerGrid, Grid computerGrid, HumanPlayer humanPlayer, Computer computerPlayer){
        btn_fin_config = new JButton("Passer au placement des objets");

        ckb_mode_ile = new JCheckBox("mode ile");
        lbl_nb_porte_avions = new JLabel("Nombre de porte avions:");
        spn_nb_porte_avions = new JSpinner();
        lbl_nb_croiseurs = new JLabel("Nombre de croiseurs:");
        spn_nb_croiseurs = new JSpinner();
        lbl_nb_contre_torpilleurs = new JLabel("Nombre de contre torpilleurs:");
        spn_nb_contre_torpilleurs = new JSpinner();
        lbl_nb_sous_marins = new JLabel("Nombre de sous-marins:");
        spn_nb_sous_marins = new JSpinner();
        lbl_nb_torpilleurs = new JLabel("Nombre de torpilleurs:");
        spn_nb_torpilleurs = new JSpinner();

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

        btn_fin_config.addActionListener(e -> {
            addBoatsToPlayer(spn_nb_porte_avions,humanPlayer);
            addBoatsToPlayer(spn_nb_croiseurs,humanPlayer);
            addBoatsToPlayer(spn_nb_contre_torpilleurs,humanPlayer);
            addBoatsToPlayer(spn_nb_sous_marins,humanPlayer);
            addBoatsToPlayer(spn_nb_torpilleurs,humanPlayer);

            new ObjectsPlacement(playerGrid, computerGrid, humanPlayer, computerPlayer);
            this.dispose();
        });



        add(layout_principal);

        setTitle("Paramètres de la partie");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void addBoatsToPlayer(JSpinner spinner, HumanPlayer player){
        for(int i = 0; i < (int) spinner.getValue();i++){
            if(spinner == spn_nb_porte_avions) player.addBoatToPlace(BoatFactory.createPorteAvion(BoatDirection.Vertical));
            if(spinner == spn_nb_croiseurs) player.addBoatToPlace(BoatFactory.createCroiseur(BoatDirection.Horizontal));
            if(spinner == spn_nb_contre_torpilleurs) player.addBoatToPlace(BoatFactory.createPorteAvion(BoatDirection.Vertical));
            if(spinner == spn_nb_sous_marins) player.addBoatToPlace(BoatFactory.createSousMarin(BoatDirection.Horizontal));
            if(spinner == spn_nb_torpilleurs) player.addBoatToPlace(BoatFactory.createTorpilleur(BoatDirection.Horizontal));

        }
    }
}
