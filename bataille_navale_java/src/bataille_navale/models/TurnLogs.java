package bataille_navale.models;

import bataille_navale.controllers.gameController.ActionType;

public class TurnLogs {
    public void showPlayerAttack(ActionType actionType, int x, int y){
        System.out.println("\u001B[32mVous avez utilisé : " + actionType + " aux coordonnées x: "+ x +" et y:" + y);
    }
    public void showComputerAttack(ActionType actionType, int x, int y){
        System.out.println("\u001B[31mLe bot a utilisé : " + actionType + " aux coordonnées x: "+ x + " et y:" + y);
    }
}
