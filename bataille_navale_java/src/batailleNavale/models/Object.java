package batailleNavale.models;

public abstract class Object {
    private int x;
    private int y;
    private int size;
    private int[][] squaresOccupied;
    public Object(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
