

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

    // Constructor
    public ShoppingManager() {
        items = new ArrayList<Item>();
        categories = new ArrayList<Category>();
        orders = new ArrayList<Order>();
        accountsManager = new AccountsManager();
    }

    // Getters
    public ArrayList<Item> getItems() { return this.items; }
    public ArrayList<Category> getCategories() { return this.categories; }

    // Display catalog of items
    public void displayCatalog() {
        if(items.size() == 0){
            System.out.println("\n\tSorry! No current items available!");
            return;
        }
        System.out.println("\n\t\tOur Catalog of Items!");
        for (int i = 0; i < items.size(); i++) {
            System.out.print("Item #" + (i + 1) + ": ");
            if (items.get(i).getStatus() == ItemStatus.available) {
                items.get(i).displayItem();
            }
        }
    }

    // Order an item & add it to cart
    public boolean orderItem(LoggedInUser user) {
        displayCatalog();
        Scanner in = new Scanner(System.in);
        int index;
        while(true){
            System.out.println("\nEnter number of item to add >> ");
            index = in.nextInt();
            if(index < items.size())
                break;
            System.out.println("\n\tINVALID item number!");
        }
        System.out.print("You selected item #" + index + ": ");
        selectItem(items.get(index - 1));
        System.out.println("Enter quantity >> ");
        float quantity = in.nextFloat();
        System.out.println("Is quantity in KG? (true/false) >> ");
        boolean isKG = in.nextBoolean();
        // Add ordered item to cart
        user.addToCart(items.get(index - 1), quantity, isKG);
        in.close();
        return false;
    }

    // Add item from catalog to the list of items to be ordered
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
        items.add(newItem);
        currentCat.addItemToCategory(newItem);
        // itemDataFlush(newItem);
        return true;
    }

    // Display item selected by user
    public void selectItem(Item item) { item.displayItem(); }

    public boolean checkOut(LoggedInUser user) { return user.checkOut(); }
    public boolean verifyPhone(String phone) { return false; }
    public boolean payOrder(float amount) { return false; }

    public void itemDataFlush(Item item) throws IOException {
        // Check if item already exists
        for (Item i : items) {
            if (i.getName().equals(item.getName()))
                return;
        }
        FileWriter catalogFile = new FileWriter("data/Items.txt", true);
        PrintWriter pw = new PrintWriter(catalogFile, true);
        pw.print(item.getName() + "," + item.getCategory() + "," + item.getDescription() + ","
                + item.getBrand() + "," + item.getImageURL() + "," + item.getPrice() + ","
                + item.getAvailableKG() + "," + item.getAvailableUnits() + "," + item.getStatus() + "\r");
        pw.flush();
        pw.close();
    }
}