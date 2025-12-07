package bataille_navale.controllers.players;

public  abstract class Player {
    private int nbBoats;

    public Player(){
        this.nbBoats = 5;
    }

    public int getNbBoats(){
        return this.nbBoats;
    }

    public void playerTurn(){
    }

    public void placeBoats(){

    }
}
