package bataille_navale.models.items;


import bataille_navale.Object;

public class Item extends Object {
    private int capacity;
    public Item(int size, int capacity){
        super(size);
        this.capacity = capacity;
    }


    public boolean canBeUsed(){
        if(this.capacity > 0){
            return true;
        }
        return false;
    }

    public void addCapacity(int add){
        this.capacity += add;
    }
}
