package bataille_navale.models.map;

import bataille_navale.Object;
import bataille_navale.models.boat.Boat;
import bataille_navale.models.boat.BoatDirection;
import bataille_navale.models.boat.Types;

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

    public void setBoats1(Grid g){
        Boat porte_avion = new Boat(5, Types.PorteAvion, BoatDirection.Horizontal);
        Boat croiseur = new Boat(4,Types.PorteAvion, BoatDirection.Vertical);
        Boat contre_torpilleur = new Boat(3,Types.PorteAvion, BoatDirection.Horizontal);
        Boat sous_marin = new Boat(3,Types.PorteAvion, BoatDirection.Vertical);
        Boat torpilleur = new Boat(2,Types.PorteAvion, BoatDirection.Horizontal);


        g.setObject(0,0, BoatDirection.Horizontal, 5,porte_avion);
        g.setObject(2,2, BoatDirection.Vertical, 4,croiseur);
        g.setObject(5,6, BoatDirection.Horizontal, 3,contre_torpilleur);
        g.setObject(8,1, BoatDirection.Vertical, 3,sous_marin);
        g.setObject(1,9, BoatDirection.Horizontal, 2,torpilleur);
    }
}
