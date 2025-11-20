package bataille_navale.models.grille;

import bataille_navale.models.Object;
import bataille_navale.models.bateau.BoatDirection;

public class Grille {
    private int height;
    private int width;
    private Object[][] grille;

    public Grille(){
        this.height = 10;
        this.width = 10;
        grille = new Object[10][10];
    }

    public Grille(int heigth, int width){
        this.height = heigth;
        this.width = width;
        grille = new Object[10][10];
    }

    public Object[][] getGrille(){
        return this.grille;
    }
    public boolean setObject(int x, int y, BoatDirection orientation, int size , Object o ){
        if(x > grille[0].length - size){
            return false;
        }
        if(y > grille[1].length - size) {
            return false;
        }
        //this.grille[x][y] = o;
        for(int i = 0; i < size; i++){
            if(orientation == BoatDirection.Vertical){
                this.grille[x-i][y] = o; // si true alors le bateau est placé verticalement, on place de haut en bas
            }
            else{
                this.grille[x][y+i] = o; // si false, on place de gauche à droite
            }
        }
        return true;
    }
}
