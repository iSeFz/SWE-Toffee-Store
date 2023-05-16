package Inventory;

/**
 * The `Item` class represents an item in a store, with various attributes such as name, category,
 * description, price, and availability.
 */
public class Item {
    // `private String name;` is declaring a private instance variable of type String named "name" in
    // the Item class. This variable will hold the name of the item.
    private String name;
    // `private String category;` is declaring a private instance variable of type String named
    // "category" in the Item class. This variable will hold the category of the item.
    private String category;
    // `private String description;` is declaring a private instance variable of type String named
    // "description" in the Item class. This variable will hold the description of the item.
    private String description;
    // `private String imageURL;` is declaring a private instance variable of type String named
    // "imageURL" in the Item class. This variable will hold the URL of the image associated with the
    // item.
    private String imageURL;
    // `private String brand;` is declaring a private instance variable of type String named "brand" in
    // the Item class. This variable will hold the brand of the item.
    private String brand;
    // `private float price;` is declaring a private instance variable of type float named "price" in
    // the Item class. This variable will hold the price of the item.
    private float price;
    // `private float availableKG;` is declaring a private instance variable of type float named
    // "availableKG" in the Item class. This variable will hold the available quantity of the item in
    // kilograms.
    private float availableKG;
    // `private int availableUnits;` is declaring a private instance variable of type int named
    // "availableUnits" in the Item class. This variable will hold the available quantity of the item
    // in units.
    private int availableUnits;
    // `private ItemStatus status;` is declaring a private instance variable of type `ItemStatus` named
    // "status" in the `Item` class. This variable will hold the current status of the item, which can
    // be either "in stock" or "out of stock". It is used to keep track of the availability of the item
    // and to prevent customers from ordering items that are out of stock.
    private ItemStatus status;

// This is a constructor method for the `Item` class. It takes in several parameters, including the
// name, category, description, image URL, brand, price, available quantity in kilograms, available
// quantity in units, and status of the item. It then assigns these values to the corresponding
// instance variables of the `Item` object being created. This constructor allows for the creation of
// new `Item` objects with specific attributes.
    public Item(String name_, String cat, String description_, String URL, String brand_, float price_, float weight, int units, ItemStatus status_){
        name = name_;
        category = cat;
        description = description_;
        imageURL = URL;
        brand = brand_;
        price = price_;
        availableUnits = units;
        availableKG = weight;
        status = status_;
    }

/**
 * This function displays the details of an item if it is not out of stock.
 */
    public void displayItem(){
        if( status == ItemStatus.outOfStock)
            return;
        System.out.println("[Name: '" + name +
        "', Category: " + category +
        ", Brand: '" + brand +
        "', Price: " + price + "]");
    }

/**
 * The function displays detailed information about an item if it is not out of stock.
 */
    public void detailedDisplay(){
        if(status == ItemStatus.outOfStock)
            return;
        System.out.println("[Name: '" + name +
                "', Category: " + category +
                ", Brand: '" + brand +
                "', Price: " + price +
                ", Available Units: " + availableUnits +
                ", Available Kg: " + availableKG + "]");
    }

    
    /**
     * This Java function changes an item to an ordered item and updates the available quantity based
     * on the quantity and unit of measurement.
     * 
     * @param quantity The quantity of the item being ordered.
     * @param isKG A boolean value indicating whether the quantity is in kilograms (true) or in units
     * (false).
     * @return An object of type OrderedItem is being returned, except in the case where there is
     * insufficient quantity, in which case no object is returned.
     */
    public OrderedItem changeItemToOrderedItem(float quantity, boolean isKG) {
        if(isKG){
            if(this.availableKG  < quantity){
                System.out.println("Insufficient Quantity!");
                System.out.println("Available quantity is: " + this.availableKG + " Kg");
            }
            else{
                this.availableKG -= quantity;
                return new OrderedItem(this, this.price, quantity, true);
            }
        }
        else{
            if(this.availableUnits < quantity){
                System.out.println("Insufficient Quantity!");
                System.out.println("Available quantity is: " + this.availableUnits + " units");
            }
            else{
                this.availableUnits -= quantity;
                return new OrderedItem(this, this.price, quantity, false);
            }
        }
        if(this.availableUnits == 0 && this.availableKG == 0)
            status = ItemStatus.outOfStock;
        return new OrderedItem();
    }

    // Getters & Setters
    /**
     * This function returns the name of an object.
     * 
     * @return The method is returning a String value which is the name of an object.
     */
    public String getName() { return this.name; }
    /**
     * The function returns the status of an item.
     * 
     * @return The method is returning the value of the `status` variable, which is of type
     * `ItemStatus`.
     */
    public ItemStatus getStatus() { return status; }
    /**
     * This function returns the category as a string.
     * 
     * @return The method is returning a String value, which is the value of the variable "category".
     */
    public String getCategory() { return category; }
    /**
     * This function returns the description of an object as a string.
     * 
     * @return The method is returning a String value, which is the value of the variable
     * "description".
     */
    public String getDescription() { return description; }
    /**
     * The function returns the URL of an image.
     * 
     * @return The method `getImageURL()` is returning a `String` value, which is the value of the
     * variable `imageURL`.
     */
    public String getImageURL() { return imageURL; }
    /**
     * The function returns the brand of an object.
     * 
     * @return The `brand` variable is being returned as a String.
     */
    public String getBrand() { return brand; }
    /**
     * The function returns the price as a float value.
     * 
     * @return The method `getPrice()` is returning a `float` value which represents the price.
     */
    public float getPrice() { return price; }
    /**
     * The function returns the available kilograms as a float value.
     * 
     * @return The method is returning the value of the variable `availableKG`, which is a float data
     * type.
     */
    public float getAvailableKG() { return availableKG; }
    /**
     * The function returns the number of available units.
     * 
     * @return The method is returning an integer value which represents the number of available units.
     */
    public int getAvailableUnits() { return availableUnits; }
    /**
     * This function sets the status of an item.
     * 
     * @param status The parameter "status" is of type "ItemStatus", which is likely an enum
     * representing the status of an item (e.g. available, checked out, on hold, etc.). The method
     * "setStatus" sets the status of an item to the value passed in as the "status" parameter.
     */
    public void setStatus(ItemStatus status) { this.status = status; }
}


