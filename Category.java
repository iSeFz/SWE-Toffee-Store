import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Item> items;
    Category(String name){
        this.name = name;
    }
    Category(){
        name = "";
    }
    public void displayItems(){
        for (Item it : items){
            if(it.getStatus() == ItemStatus.available){
                it.displayItem();
            }
        }
    }
    public void addItem(Item newItem){
        items.add(newItem);
    }
    public String getName(){
        return name;
    }
}
