package bataille_navale.models.Objects.items.boat;

public class BoatCoordinates {
    private int x;
    private int y;

    public BoatCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
