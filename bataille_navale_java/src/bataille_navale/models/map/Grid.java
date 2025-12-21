package bataille_navale.models.map;

import bataille_navale.models.Object;
import bataille_navale.controllers.players.Player;
import bataille_navale.models.GridObserver;
import bataille_navale.models.Objects.ObjectType;
import bataille_navale.models.Objects.island.Island;
import bataille_navale.models.Objects.boat.Boat;
import bataille_navale.models.Objects.boat.BoatDirection;
import bataille_navale.models.Objects.boat.BoatFactory;
import bataille_navale.models.Objects.items.traps.Trap;
import bataille_navale.models.Objects.weapons.Bomb;
import bataille_navale.models.Objects.weapons.Sonar;

import java.util.ArrayList;
import java.util.List;

public class Grid{
    private List<GridObserver> observers = new ArrayList<>();
    private int height;
    private int width;
    private Object[][] grille;
    private int nbBoats;
    private int nbBoatsSunk;

    public Grid(){
        this.nbBoats = 0;
        this.nbBoatsSunk = 0;
        this.height = 10;
        this.width = 10;
        grille = new Object[10][10];
    }

    public Grid(int heigth, int width){
        this.nbBoats = 0;
        this.nbBoatsSunk = 0;
        this.height = heigth;
        this.width = width;
        grille = new Object[10][10];
    }

    public Object[][] getGrille(){
        return this.grille;
    }

    public Object getCase(int x, int y){
        return this.grille[x][y];
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

    public int getNbBoats(){ return this.nbBoats;}

    public int getNbBoatsSunk(){return this.nbBoatsSunk;}

    public void setIsland(){
        for(int i= 3; i < 7; i++){
            for(int j = 3; j < 7; j++){
                this.grille[i][j] = new Island(1, Island.chooseItemToPlace());
                notifyObserversCell(i,j);
            }
        }
    }

    public boolean setBoat(int x, int y, Boat boat){
        if(x > getWidth() - boat.getSize()){
            System.out.println("trop loin");
            return false;
        }
        if(y > getHeight() - boat.getSize()) {
            System.out.println("trop long");
            return false;
        }
        for(int i = 0; i < boat.getSize(); i++){
            if(boat.getBoatDirection() == BoatDirection.Vertical){
                this.grille[x][y+i] = boat;// si true alors le bateau est placé verticalement, on place de haut en bas
                boat.setBoatCoordinates(x,y+i);
            }
            else{
                this.grille[x+i][y] = boat; // si false, on place de gauche à droite
                boat.setBoatCoordinates(x+i,y);
            }
        }
        notifyObserversGrid();
        return true;
    }

    public boolean setTrap(int x, int y, Trap trap ){
            if(x >= grille.length || y >= grille[0].length){
                return false;
            }
            if(x < 0 || y < 0){
                return false;
            }
            if(this.grille[x][y] != null){
                return false;
            }
            this.grille[x][y] = trap;
            notifyObserversGrid();
            return true;
        }

    public void removeBoat(Boat boat){
        for(int i = 0; i < boat.getBoatSize();i++){
            int x = boat.getBoatCoordinates().get(i).getX();
            int y = boat.getBoatCoordinates().get(i).getY();
            this.grille[x][y] = new BateauCoule(1);

        }
        notifyObserversGrid();
    }

    public void basicAttack(Player player, int x, int y){
        if(this.grille[x][y] != null){
            Object o = grille[x][y];
            if(o.getType() == ObjectType.BOAT){
                this.grille[x][y] = new CaseAttaquee(1);
                o.onHit(player, x, y);
                notifyObserversCell(x,y);
            }
            if(o.getType() == ObjectType.WATER){
                o.onHit(player, x, y);
            }
            if(o.getType() == ObjectType.ISLAND){
                o.onHit(player, x, y);
                this.grille[x][y] = new IleTouchee(1, ObjectType.HIT_ISLAND);
                notifyObserversCell(x,y);
            }
            if(o.getType() == ObjectType.TRAP){
                o.onHit(player, x, y);
                this.grille[x][y] = new TrapHit(1, ObjectType.HIT_TRAP);
                notifyObserversCell(x,y);
            }
        }
        else if(this.grille[x][y] == null){
            this.grille[x][y] = new Water(1);
            notifyObserversCell(x,y);
        }
    }

    public int sonarAttack(Sonar sonar, Player player, int x, int y){
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;

                if (cellExists(nx, ny)
                        && this.grille[nx][ny] != null
                        && this.grille[nx][ny].getType() == ObjectType.BOAT) {
                    count++;
                }
            }
        }

        return count;
    }

    public void bombAttack(Bomb bomb, Player player, int x, int y){
        basicAttack(player, x, y);
        if(this.cellExists(x, y-1)){
            basicAttack(player, x, y-1);
        }
        if(this.cellExists(x, y+1)){
            basicAttack(player, x, y+1);
        }
        if(this.cellExists(x+1, y)){
            basicAttack(player, x+1, y);
        }
        if(this.cellExists(x-1, y)){
            basicAttack(player, x-1, y);
        }
        notifyObserversGrid();

    }

    public boolean cellExists(int x, int y){
        if(this.width-1 < x || x < 0){
            return false;
        }
        if(this.height-1 < y || y < 0){
            return false;
        }
        return true;
    }

    public void setBoats1(){
        Boat porte_avion = BoatFactory.createPorteAvion(BoatDirection.Horizontal);
        Boat croiseur = BoatFactory.createCroiseur(BoatDirection.Vertical);
        Boat contre_torpilleur = BoatFactory.createContreTorpilleur(BoatDirection.Horizontal);
        Boat sous_marin = BoatFactory.createSousMarin(BoatDirection.Vertical);
        Boat torpilleur = BoatFactory.createTorpilleur(BoatDirection.Horizontal);

        this.setBoat(0,0, porte_avion);
        this.setBoat(2,2, croiseur);
        this.setBoat(5,6,contre_torpilleur);
        this.setBoat(7,1, sous_marin);
        this.setBoat(1,8, torpilleur);

        this.nbBoats+=5;
    }

    public boolean allBoatsSunk(){
        return this.nbBoats == this.nbBoatsSunk;
    }

    public void addNbBoatsSunk(int nb){
        this.nbBoatsSunk+= nb;
    }

    private boolean canPlaceBoat(int x, int y, Boat boat) {
        for (int i = 0; i < boat.getSize(); i++) {
            int nx = x;
            int ny = y;

            if (boat.getBoatDirection() == BoatDirection.Vertical) {
                ny += i;
            } else {
                nx += i;
            }

            if (!cellExists(nx, ny)) {
                return false;
            }

            if (grille[nx][ny] != null) {
                return false;
            }
        }
        return true;
    }

    private void placeBoatRandomly(Boat boat) {
        boolean placed = false;

        while (!placed) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);

            BoatDirection direction = Math.random() < 0.5
                    ? BoatDirection.Horizontal
                    : BoatDirection.Vertical;

            boat.setBoatDirection(direction);

            if (canPlaceBoat(x, y, boat)) {
                boolean success = setBoat(x, y, boat);
                placed = success;
            }
        }
    }

    public void placeBoatsRandom() {
        List<Boat> boats = new ArrayList<>();

        boats.add(BoatFactory.createPorteAvion(BoatDirection.Horizontal));
        boats.add(BoatFactory.createCroiseur(BoatDirection.Horizontal));
        boats.add(BoatFactory.createContreTorpilleur(BoatDirection.Horizontal));
        boats.add(BoatFactory.createSousMarin(BoatDirection.Horizontal));
        boats.add(BoatFactory.createTorpilleur(BoatDirection.Horizontal));

        for (Boat boat : boats) {
            placeBoatRandomly(boat);
        }

        this.nbBoats += boats.size();
    }

    //PARTIE OBSERVER

    public void addObserver(GridObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GridObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserversGrid() {
        for (GridObserver o : observers) o.update(this);
    }

    public void notifyObserversCell(int x, int y){
        for (GridObserver o : observers) o.updateCell(this, x, y);
    }
}
