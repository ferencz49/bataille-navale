package batailleNavale.models.grille;

import batailleNavale.models.Object;

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

}
