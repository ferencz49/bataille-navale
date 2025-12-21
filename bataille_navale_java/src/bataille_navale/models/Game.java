package bataille_navale.models;

import bataille_navale.controllers.gameController.ActionType;
import bataille_navale.controllers.players.Computer;
import bataille_navale.controllers.players.HumanPlayer;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.Objects.ObjectType;

import javax.swing.*;

public class Game {
    private HumanPlayer humanPlayer;
    private Player computerPlayer;

    public void createGame(HumanPlayer human, Computer computer){
        this.humanPlayer = human;
        this.computerPlayer = computer;
    }

    public boolean canPlayAt(int x, int y){
        Object obj = humanPlayer.getEnemyGrid().getCase(x,y);
        if(obj == null) return true;

        return obj.getType() != ObjectType.HIT_BOAT
                && obj.getType() != ObjectType.SUNK_BOAT
                && obj.getType() != ObjectType.WATER
                && obj.getType() != ObjectType.HIT_ISLAND
                && obj.getType() != ObjectType.HIT_TRAP;
    }


    public Integer playerAttack(Player player, ActionType action, int x, int y) {

        if (!canPlayAt(x, y)) {
            return null;
        }

        switch (action) {

            case BASIC_ATTACK -> {
                humanPlayer.basicAttack(player, x, y);
                return -1;
            }

            case BOMB -> {
                if (!player.usableItemsContainsBomb()) {
                    return null;
                }
                humanPlayer.useBomb(x, y);
                return -1;
            }

            case SONAR -> {
                if (!player.usableItemsContainsSonar()) {
                    return null;
                }
                return humanPlayer.useSonar(x, y);
            }
        }

        // sécurité (jamais atteint normalement)
        return null;
    }

    public boolean isGameEnded(){
        return humanPlayer.getEnemyGrid().allBoatsSunk() || computerPlayer.getEnemyGrid().allBoatsSunk();
    }
}
