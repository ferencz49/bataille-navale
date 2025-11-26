package bataille_navale.models.map;

import bataille_navale.Object;
import bataille_navale.models.boat.BoatDirection;

public class Grid {
    private int height;
    private int width;
    private Object[][] grille;

    public Grid(){
        this.height = 10;
        this.width = 10;
        grille = new Object[10][10];
    }

    public Grid(int heigth, int width){
        this.height = heigth;
        this.width = width;
        grille = new Object[10][10];
    }

    public Object[][] getGrille(){
        return this.grille;
    }

    public Object getCase(int x, int y){return this.grille[x][y];}

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
                this.grille[x][y+i] = o; // si true alors le bateau est placé verticalement, on place de haut en bas
            }
            else{
                this.grille[x+i][y] = o; // si false, on place de gauche à droite
            }
        }
        return true;
    }

    public void removeObject(int x, int y, BoatDirection orientation, int size, Object o){
        for(int i = 0; i < size; i++){
            if(orientation == BoatDirection.Vertical){
                this.grille[x-i][y] = null;
            }
            else{
                this.grille[x][y+i] = null;
            }
        }
    }
}
