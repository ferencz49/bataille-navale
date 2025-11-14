package batailleNavale.models;

public abstract class Object {
    private int x;
    private int y;
    private int size;
    private int[][] squaresOccupied;
    public Object(int size){
        this.size = size;
    }
}
