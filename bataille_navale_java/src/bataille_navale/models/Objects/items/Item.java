package bataille_navale.models.Objects.items;


import bataille_navale.Object;

abstract public class Item extends Object {
    private int capacity;
    public Item(int capacity){
        super(1);
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
