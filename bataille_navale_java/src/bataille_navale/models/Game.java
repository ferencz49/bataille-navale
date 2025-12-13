package bataille_navale.models;

import bataille_navale.controllers.players.Player;

public class Game {
    private Player humanPlayer;
    private Player computerPlayer;

    public void createGame(){
        humanPlayer.placeBoats();
        computerPlayer.placeBoats();
    }

    public void playGame(){
        if(!humanPlayer.getGrid().allBoatsSunk() || !computerPlayer.getGrid().allBoatsSunk()){
            humanPlayer.playerTurn();
            computerPlayer.playerTurn();
            playGame();
        }
    }

    public boolean isGameEnded(){
        if (computerPlayer.getGrid().getNbBoats() == 0 || humanPlayer.getGrid().getNbBoats() == 0) {
            return true;
        }
        return false;
    }
}
