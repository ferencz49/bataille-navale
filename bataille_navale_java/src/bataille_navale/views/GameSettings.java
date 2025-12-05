package bataille_navale.views;


import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {



    public GameSettings(){
        JButton btn_fin_config = new JButton("Passer au placement des objets");
        JCheckBox ckb_mode_ile = new JCheckBox("mode ile");
        JLabel lbl_nb_porte_avions = new JLabel("Nombre de porte avions:");
        JSpinner spn_nb_porte_avions = new JSpinner();
        JLabel lbl_nb_croiseurs = new JLabel("Nombre de porte avions:");

        JPanel layout_principal = new JPanel(new BorderLayout());
        layout_principal.add(btn_fin_config, BorderLayout.SOUTH);

        JPanel layout_secondaire_centre = new JPanel();
        layout_secondaire_centre.setLayout(new BoxLayout(layout_secondaire_centre, BoxLayout.Y_AXIS));
        layout_secondaire_centre.add(Box.createVerticalStrut(20));
        layout_secondaire_centre.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        layout_secondaire_centre.add(ckb_mode_ile);
        layout_secondaire_centre.add(lbl_nb_porte_avions);
        layout_secondaire_centre.add(spn_nb_porte_avions);
        layout_secondaire_centre.add(lbl_nb_croiseurs);
        //on ajoute le layout qui contient les boutons permettant de setup la game au centre du layout principal
        layout_principal.add(layout_secondaire_centre, BorderLayout.CENTER);



        add(layout_principal);

        setTitle("Paramètres de la partie");
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
