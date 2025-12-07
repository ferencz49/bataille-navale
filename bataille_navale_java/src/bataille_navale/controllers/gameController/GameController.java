package bataille_navale.controllers.gameController;

import bataille_navale.views.AfficherGrille;

public class GameController {
    private AfficherGrille view;
    private ActionType selectedAction;

    public GameController(AfficherGrille view){
        this.view = view;

        view.getUtiliserAttaque().addActionListener(e -> selectedAction = ActionType.BASIC_ATTACK);
        view.getUtiliserBombe().addActionListener(e -> selectedAction = ActionType.BOMB);


    }

    public void onBasicAttackClicked(){
    }

    public void onBombAttackClicked(){
    }


}
