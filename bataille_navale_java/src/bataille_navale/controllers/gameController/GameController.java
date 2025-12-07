package bataille_navale.controllers.gameController;

public class GameController {
    private ActionType selectedAction;

    public void onBasicAttackClicked(){
        this.selectedAction = ActionType.BASIC_ATTACK;
    }

    public void onBombAttackClicked(){
        this.selectedAction = ActionType.BOMB;
    }


}
