package Inventory;

import java.util.ArrayList;

/**
 * The `Category` class stores a list of items and their names, and provides methods to add items to
 * the list, display available items, and retrieve the category name.
 */
public class Category {
    // `String name;` is declaring a variable called `name` of type `String` in the `Category` class.
    // This variable is used to store the name of the category.
    String name;
    // `ArrayList<Item> items;` is declaring a variable called `items` of type `ArrayList` that can
    // store objects of type `Item`. This variable is used to store the list of items that belong to
    // the category.
    ArrayList<Item> items;

// This is a constructor method for the `Category` class that takes a `String` parameter called `name`.
// When a new `Category` object is created using this constructor, the `name` variable of the object is
// set to the value of the `name` parameter passed to the constructor. Additionally, a new `ArrayList`
// object of type `Item` is created and assigned to the `items` variable of the object.
    public Category(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }
// This is a no-argument constructor method for the `Category` class. When a new `Category` object is
// created using this constructor, the `name` variable of the object is set to an empty string (`""`).
// Additionally, a new `ArrayList` object of type `Item` is created and assigned to the `items`
// variable of the object. This constructor can be used to create a new `Category` object with default
// values for its instance variables.
    public Category(){
        name = "";
        items = new ArrayList<Item>();
    }
/**
 * This function displays all available items in a list.
 */
    public void displayItems(){
        for (Item it : items){
            if(it.getStatus() == ItemStatus.available){
                it.displayItem();
            }
        }
    }
/**
 * This Java function adds a new item to a category's list of items.
 * 
 * @param newItem The parameter "newItem" is an object of the class "Item" that is being passed as an
 * argument to the method "addItemToCategory". This object represents a new item that needs to be added
 * to a category.
 */
    public void addItemToCategory(Item newItem){
        items.add(newItem);
    }
/**
 * The function returns the name of an object.
 * 
 * @return The method `getName()` is returning the value of the variable `name`.
 */
    public String getName(){
        return name;
    }
}
