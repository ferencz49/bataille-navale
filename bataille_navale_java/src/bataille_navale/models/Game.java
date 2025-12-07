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
        while(!isGameEnded()){
            humanPlayer.playerTurn();
            computerPlayer.playerTurn();
        }
    }

    public boolean isGameEnded(){
        if (computerPlayer.getNbBoats() == 0 || humanPlayer.getNbBoats() == 0) {
            return true;
        }
        return false;
    }
}
