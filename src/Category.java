
import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Item> items;

    public Category(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }
    public Category(){
        name = "";
        items = new ArrayList<Item>();
    }
    public void displayItems(){
        for (Item it : items){
            if(it.getStatus() == ItemStatus.available){
                it.displayItem();
            }
        }
    }
    public void addItemToCategory(Item newItem){
        items.add(newItem);
    }
    public String getName(){
        return name;
    }
}
