import java.util.ArrayList;
import java.util.Scanner;

class ShoppingManager{
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Order> orders;

//  public Item searchItem(String itemName){}
    public void displayCatalog(){
        for (int i = 0; i < items.size(); i++) {
            System.out.print("Item " + i + 1 + ": ");
            if(items.get(i).getStatus() == ItemStatus.available) {
                items.get(i).displayItem();
            }
        }
    }

    public boolean orderItem(int index){
        Scanner in = new Scanner(System.in);
        float quantity = in.nextFloat();
        boolean isKG = in.nextBoolean();
        items.get(index - 1).orderItem(quantity, isKG);
        // TODO: add orderedItem to cart
    }

    public boolean addItem(String name, String cat, String description, String imageURL, String brand, float price, float availableKG, int availableUnits){

        // Search for category object
        Category currentCat = new Category();
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getName().equals(cat)){
                currentCat = categories.get(i);
            }
        }

        // Creating new category if not found
        if(currentCat.getName().equals("")){
            currentCat = new Category(cat);
            categories.add(currentCat);
        }

        // Setting status based on quantity
        ItemStatus stat;
        if(availableKG > 0 || availableUnits > 0){
            stat = ItemStatus.onSale;
        }
        else{
            stat = ItemStatus.outOfStock;
        }

        Item newItem = new Item(name, cat, description, imageURL, brand, price, availableKG, availableUnits, stat);
        items.add(newItem);
        currentCat.addItem(newItem);


        return false;
    }
//    boolean checkOut(user LoggedInUser ){
//
//    }

    public void selectItem(Item item){
        item.displayItem();
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public ArrayList<Category> getCategories(){
        return this.categories;
    }

//    public void setOrder(Address address, PaymentMethod paymentMethod){}
    public boolean verifyPhone(String phone){
        return false;
    }
    public boolean payOrder(float amount){
        return false;
    }

}