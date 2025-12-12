package bataille_navale.controllers.gameController;

import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.controllers.players.Player;
import bataille_navale.views.AfficherGrille;
import bataille_navale.views.GameEnd;

public class GameController {
    private AfficherGrille view;
    private HumanPlayer humanPlayer;
    private Computer computerPlayer;
    private ActionType selectedAction = ActionType.BASIC_ATTACK;
    private Player winner;

    public GameController(AfficherGrille view, HumanPlayer humanPlayer, Computer computerPlayer){
        this.view = view;
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;

        view.getUtiliserAttaque().addActionListener(e -> selectedAction = ActionType.BASIC_ATTACK);
        view.getUtiliserBombe().addActionListener(e -> selectedAction = ActionType.BOMB);

        for (int y = 0; y < humanPlayer.getEnemyGrid().getHeight(); y++) {
            for (int x = 0; x < humanPlayer.getEnemyGrid().getWidth(); x++) {
                int finalX = x;
                int finalY = y;
                view.getAfficheGrilleEnnemi()[y][x].addActionListener(e -> handleCellClick(humanPlayer, finalX, finalY));
            }

        }
    }


    // toute la logique de la partie est ici mdr
    private void handleCellClick(Player player, int x, int y) {
        switch (selectedAction) {
            case BASIC_ATTACK -> humanPlayer.basicAttack(player, x, y);
            case BOMB -> humanPlayer.useBomb(x, y);
        }
        // mise à jour automatique de la vue
        humanPlayer.getEnemyGrid().notifyObservers();

        if(computerPlayer.allBoatsSunk()){
            view.dispose();
            this.winner = humanPlayer;
            GameEnd e = new GameEnd(this.humanPlayer, this.computerPlayer, this.winner);
        }

        computerPlayer.playerTurn(this.computerPlayer);
        computerPlayer.getEnemyGrid().notifyObservers();
        if(humanPlayer.allBoatsSunk()){
            view.dispose();
            this.winner = computerPlayer;
            GameEnd e = new GameEnd(this.humanPlayer, this.computerPlayer, this.winner);
        }
    }


}
