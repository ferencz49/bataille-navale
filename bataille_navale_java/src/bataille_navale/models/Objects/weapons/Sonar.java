package bataille_navale.models.Objects.weapons;

import bataille_navale.models.map.Grid;

public class Sonar extends Weapon{
    private boolean canBeUsed = true;
    private boolean submarineIsAlive = true;

    public Sonar(int capacity){
        super(capacity);
    }

    public boolean getCanBeUsed() {
        return canBeUsed;
    }

    public void setCanBeUsed(boolean canBeUsed) {
        this.canBeUsed = canBeUsed;
    }

    public boolean getSubmarineIsAlive() {
        return submarineIsAlive;
    }

    public void setSubmarineIsAlive(boolean submarineIsAlive) {
        this.submarineIsAlive = submarineIsAlive;
    }

    public int useWeapons(int x, int y, Grid g){
        int nbBoats = 0;
        for(int j = y-1; j < y+2; j++){
            for(int i = x-1; i < x+2;i++){
                if(g.getCase(i,j) != null){
                    nbBoats++;
                }
            }
        }

        return nbBoats;
    }
}
