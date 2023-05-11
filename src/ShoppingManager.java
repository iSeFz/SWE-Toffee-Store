

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingManager {
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Order> orders;
    private AccountsManager accountsManager;

    //  public Item searchItem(String itemName){}

    public ShoppingManager() {
        items = new ArrayList<Item>();
        categories = new ArrayList<Category>();
        orders = new ArrayList<Order>();
        accountsManager = new AccountsManager();
    }
    public void displayCatalog() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print("Item " + i + 1 + ": ");
            if (items.get(i).getStatus() == ItemStatus.available) {
                items.get(i).displayItem();
            }
        }
    }

    public boolean orderItem(int index) {
        Scanner in = new Scanner(System.in);
        float quantity = in.nextFloat();
        boolean isKG = in.nextBoolean();
        items.get(index - 1).orderItem(quantity, isKG);
        // TODO: add orderedItem to cart
        return false;
    }

    public boolean addItem(String name, String cat, String description, String imageURL, String brand, float price, float availableKG, int availableUnits) throws IOException {

        // Search for category object
        Category currentCat = new Category();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(cat)) {
                currentCat = categories.get(i);
                break;
            }
        }

        // Creating new category if not found
        if (currentCat.getName().equals("")) {
            currentCat = new Category(cat);
            categories.add(currentCat);
        }

        // Setting status based on quantity
        ItemStatus stat;
        if (availableKG > 0 || availableUnits > 0) {
            stat = ItemStatus.available;
        } else {
            stat = ItemStatus.outOfStock;
        }

        Item newItem = new Item(name, cat, description, imageURL, brand, price, availableKG, availableUnits, stat);
        itemDataFlush(newItem);
        items.add(newItem);
        currentCat.addItemToCategory(newItem);


        return false;
    }

    boolean checkOut(LoggedInUser user) {
        return user.checkOut();
    }

    public void selectItem(Item item) {
        item.displayItem();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public boolean verifyPhone(String phone) {
        return false;
    }

    public boolean payOrder(float amount) {
        return false;
    }

    public void itemDataFlush(Item item) throws IOException {
        FileWriter fw = new FileWriter("data/Items.txt");
        PrintWriter pw = new PrintWriter(fw, true);
        pw.print(item.getName() + "," + item.getCategory() + "," + item.getDescription() + ","
                + item.getImageURL() + "," + item.getBrand() + "," + item.getPrice() + ","
                + item.getAvailableKG() + "," + item.getAvailableUnits() + "," + item.getStatus());
        pw.flush();
        pw.close();
    }
}