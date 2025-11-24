package bataille_navale;

public abstract class Object {
    private int size;
    private int[][] squaresOccupied;
    public Object(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }
}
