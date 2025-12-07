package bataille_navale.controllers.gameController;

import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.controllers.players.Player;
import bataille_navale.views.AfficherGrille;

public class GameController {
    private AfficherGrille view;
    private HumanPlayer humanPlayer;
    private ActionType selectedAction = ActionType.BASIC_ATTACK;

    public GameController(AfficherGrille view, HumanPlayer humanPlayer){
        this.view = view;
        this.humanPlayer = humanPlayer;

        view.getUtiliserAttaque().addActionListener(e -> selectedAction = ActionType.BASIC_ATTACK);
        view.getUtiliserBombe().addActionListener(e -> selectedAction = ActionType.BOMB);

        for (int y = 0; y < humanPlayer.getEnemyGrid().getHeight(); y++) {
            for (int x = 0; x < humanPlayer.getEnemyGrid().getWidth(); x++) {
                int finalX = x;
                int finalY = y;
                view.getAfficheGrilleEnnemi()[y][x].addActionListener(e -> handleCellClick(finalX, finalY));
            }

        }
    }

    public void onBasicAttackClicked(){
    }

    public void onBombAttackClicked(){
    }

    private void handleCellClick(int x, int y) {
        switch (selectedAction) {
            case BASIC_ATTACK -> humanPlayer.basicAttack(x, y);
            case BOMB -> humanPlayer.useBomb(x, y);
        }
        // mise à jour automatique de la vue
        humanPlayer.getEnemyGrid().notifyObservers();
    }


}
