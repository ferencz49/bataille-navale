package bataille_navale.models.Objects.items;


import bataille_navale.models.Object;
import bataille_navale.models.Objects.ObjectType;

abstract public class Item extends Object {
    private int capacity;
    public Item(int capacity, ObjectType objectType){
        super(1,objectType);
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
