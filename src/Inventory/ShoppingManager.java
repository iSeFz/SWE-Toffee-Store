package Inventory;

import Accounts.AccountsManager;
import Accounts.GeneralUser;
import Accounts.LoggedInUser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ShoppingManager class manages items, categories, and orders in a shopping system, allowing users
 * to add items to their cart, display a catalog, and check out.
 */
public class ShoppingManager {
    
// These are instance variables of the class `ShoppingManager`.
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Order> orders;
    private AccountsManager accountsManager;


    // This is the constructor of the `ShoppingManager` class. It initializes the instance variables
    // `items`, `categories`, and `orders` as new empty ArrayLists.
    public ShoppingManager() {
        items = new ArrayList<Item>();
        categories = new ArrayList<Category>();
        orders = new ArrayList<Order>();
    }

    
/**
 * This function sets the accounts manager for the current object.
 * 
 * @param accountsManager The parameter "accountsManager" is an object of the class "AccountsManager".
 * The method "setAccountsManager" sets the value of the instance variable "accountsManager" to the
 * value passed as the parameter.
 */
    public void setAccountsManager(AccountsManager accountsManager) {
        this.accountsManager = accountsManager;
    }

    
    /**
     * The function returns an ArrayList of Item objects.
     * 
     * @return An ArrayList of Item objects is being returned.
     */
    public ArrayList<Item> getItems() { return this.items; }
    /**
     * The function returns an ArrayList of Category objects.
     * 
     * @return An ArrayList of Category objects is being returned.
     */
    public ArrayList<Category> getCategories() { return this.categories; }

/**
 * This function displays the available items in a catalog.
 */
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

/**
 * This Java function allows a user to order an item by selecting it from a catalog, specifying the
 * quantity and whether it is in kilograms, and adding it to their cart.
 * 
 * @param user The user parameter is an instance of the GeneralUser class, which represents a general
 * user of the system. The method orderItem() takes this user as input and adds an item to their cart.
 * @return A boolean value is being returned.
 */
    public boolean orderItem(GeneralUser user) throws IOException {
        displayCatalog();
        Scanner in = new Scanner(System.in);
        int index;
        while(true){
            System.out.print("\nEnter number of item to add >> ");
            index = in.nextInt();
            if(index <= items.size())
                break;
            System.out.println("\n\tINVALID item number!");
        }
        System.out.println("You selected item #" + index);
        selectItem(items.get(index - 1));
        System.out.print("Enter quantity >> ");
        float quantity = in.nextFloat();
        System.out.print("Is quantity in KG? (true/false) >> ");
        boolean isKG = in.nextBoolean();
        OrderedItem oItem = items.get(index - 1).changeItemToOrderedItem(quantity, isKG);
        if(oItem.getQuantity() == 0)
            return false;
        itemDataFlush();
        user.addToCart(oItem);
        System.out.println("\n\tItem added to cart successfully!");
        return true;
    }

    /**
     * This Java function adds a new item to a list of items, creates a new category if necessary, and
     * sets the item's status based on its quantity.
     * 
     * @param name The name of the item being added to the inventory.
     * @param cat The category of the item being added.
     * @param description A String that describes the item being added.
     * @param imageURL The URL (Uniform Resource Locator) of the image associated with the item being
     * added.
     * @param brand The brand of the item being added to the inventory.
     * @param price The price of the item being added as a float value.
     * @param availableKG The amount of the item available in kilograms.
     * @param availableUnits The number of units of the item that are currently available in stock.
     * @return A boolean value indicating whether the item was successfully added or not.
     */
    
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

    
    /**
     * The function selects an item and displays its details.
     * 
     * @param item The parameter "item" is an object of the class "Item". It is being passed as an
     * argument to the method "selectItem". The method then calls the "detailedDisplay" method of the
     * "Item" class on the passed object to display its details.
     */
    public void selectItem(Item item) { item.detailedDisplay(); }

    /**
     * The function checks out a logged-in user.
     * 
     * @param user The parameter "user" is an object of the class "LoggedInUser". It is likely that
     * this method is a part of a larger program that manages user accounts and allows them to check
     * out items. The "LoggedInUser" class probably contains information about the user, such as their
     * name, ID,
     * @return A boolean value is being returned. The value depends on the implementation of the
     * `checkOut()` method of the `LoggedInUser` class.
     */
    public boolean checkOut(LoggedInUser user) { return user.checkOut(); }
    /**
     * The function "verifyPhone" returns a boolean value of false.
     * 
     * @param phone The parameter "phone" is a string representing a phone number that needs to be
     * verified.
     * @return The method is returning a boolean value of false.
     */
    public boolean verifyPhone(String phone) { return false; }
    /**
     * The function payOrder returns false and takes a float amount as input.
     * 
     * @param amount The parameter "amount" is a float data type representing the amount of money to be
     * paid for an order.
     * @return The method is returning a boolean value of false.
     */
    public boolean payOrder(float amount) { return false; }

/**
 * The function writes item data to a file in a specific format.
 */
    public void itemDataFlush() throws IOException {
        FileWriter catalogFile = new FileWriter("data/Items.txt");
        PrintWriter pw = new PrintWriter(catalogFile, true);
        for (Item item: items) {
            pw.print(item.getName() + "," + item.getCategory() + "," + item.getDescription() + ","
                    + item.getBrand() + "," + item.getImageURL() + "," + item.getPrice() + ","
                    + item.getAvailableKG() + "," + item.getAvailableUnits() + "," + item.getStatus() + "\r");
            pw.flush();
        }
    }
}