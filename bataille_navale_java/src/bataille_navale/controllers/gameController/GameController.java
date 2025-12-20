package bataille_navale.controllers.gameController;

import bataille_navale.models.Object;
import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.TurnLogs;
import bataille_navale.views.AfficherGrille;
import bataille_navale.views.GameEnd;

import javax.swing.*;

public class GameController {
    private AfficherGrille view;
    private HumanPlayer humanPlayer;
    private Computer computerPlayer;
    private ActionType selectedAction = ActionType.BASIC_ATTACK;
    private Player winner;
    private TurnLogs turnLogs;

    public GameController(AfficherGrille view, HumanPlayer humanPlayer, Computer computerPlayer){
        this.view = view;
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.turnLogs = new TurnLogs();

        view.getUtiliserAttaque().addActionListener(e -> selectedAction = ActionType.BASIC_ATTACK);
        view.getUtiliserBombe().addActionListener(e -> selectedAction = ActionType.BOMB);
        view.getUtiliserSonar().addActionListener(e -> selectedAction = ActionType.SONAR);

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
        Object obj = null;
        if(humanPlayer.getEnemyGrid().getCase(x,y) != null){
            obj = humanPlayer.getEnemyGrid().getCase(x,y);
        }
        if((obj != null) && (obj.getType() == ObjectType.HIT_BOAT || obj.getType() == ObjectType.SUNK_BOAT || obj.getType() == ObjectType.WATER)){
            return;
        }
        switch (selectedAction) {
            case BASIC_ATTACK -> humanPlayer.basicAttack(player, x, y);
            case BOMB -> {
                if(!player.usableItemsContainsBomb()){
                    return;

                }
                humanPlayer.useBomb(x, y);
            }
            case SONAR -> {
                if(!player.usableItemsContainsSonar()){
                    return;
                }
                int result = humanPlayer.useSonar(x, y);
                JOptionPane.showMessageDialog(view, result, "résultat du sonar",0 );
            }
        }
        turnLogs.showPlayerAttack(selectedAction, x, y);
        // mise à jour automatique de la vue

        if(humanPlayer.getEnemyGrid().allBoatsSunk()){
            view.dispose();
            this.winner = humanPlayer;
            GameEnd e = new GameEnd(this.humanPlayer, this.computerPlayer, this.winner);
        }

        int[] res = computerPlayer.playerTurn(this.computerPlayer);
        turnLogs.showComputerAttack(ActionType.BASIC_ATTACK, res[0],res[1]);

        if(computerPlayer.getEnemyGrid().allBoatsSunk()){
            view.dispose();
            this.winner = computerPlayer;
            GameEnd e = new GameEnd(this.humanPlayer, this.computerPlayer, this.winner);
        }
    }


}
