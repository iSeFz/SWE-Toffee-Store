

/**
 * The `OrderedItem` class represents an item that has been ordered, with information such as the item
 * itself, its current price, quantity, and whether it is sold by weight or not, as well as methods to
 * calculate the total price and get/set the quantity.
 */
public class OrderedItem {
    // `Item item;` is declaring a variable named `item` of type `Item`. This variable will be used to
    // store an instance of the `Item` class.
    Item item;
    // `float currentPrice;` is declaring a variable named `currentPrice` of type `float`. This
    // variable will be used to store the current price of the ordered item.
    float currentPrice;
    // `float quantity;` is declaring a variable named `quantity` of type `float`. This variable will
    // be used to store the quantity of the ordered item.
    float quantity;
    // `boolean isKG;` is declaring a variable named `isKG` of type `boolean`. This variable will be
    // used to store whether the ordered item is sold by weight (kilogram) or not. If `isKG` is `true`,
    // it means the item is sold by weight, and if it is `false`, it means the item is sold by
    // quantity.
    boolean isKG;

// This is a constructor method for the `OrderedItem` class. It takes four parameters: `item` of type
// `Item`, `currentPrice` of type `float`, `quantity` of type `float`, and `isKG` of type `boolean`.
// When an instance of the `OrderedItem` class is created using this constructor, the values of these
// parameters are used to initialize the corresponding instance variables of the class (`item`,
// `currentPrice`, `quantity`, and `isKG`). The `this` keyword is used to refer to the instance
// variables of the class, to distinguish them from the parameters with the same names.
    public OrderedItem(Item item, float currentPrice, float quantity, boolean isKG) {
        this.item = item;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.isKG = isKG;
    }

// This is a no-argument constructor method for the `OrderedItem` class. It initializes the `quantity`
// and `currentPrice` instance variables to 0. This constructor can be used to create an instance of
// the `OrderedItem` class with default values for `quantity` and `currentPrice`.
    public OrderedItem() {
        quantity = 0;
        currentPrice = 0;
    }

/**
 * This function calculates the total price by multiplying the current price with the quantity.
 * 
 * @return The method `calcPrice()` is returning the result of multiplying the `currentPrice` by the
 * `quantity`.
 */
    public float calcPrice() {
        return currentPrice * quantity;
    }

    
    /**
     * The function returns the quantity as a float value.
     * 
     * @return The method is returning a float value which represents the quantity.
     */
    public float getQuantity() { return quantity; }
    /**
     * The function returns an object of type Item.
     * 
     * @return The method is returning an object of the class `Item`.
     */
    public Item getItem() { return item; }
    /**
     * The function returns a boolean value indicating whether the type is in kilograms or not.
     * 
     * @return A boolean value is being returned. The value returned is the value of the variable
     * `isKG`.
     */
    public boolean getType() { return isKG; }

/**
 * This function sets the quantity of a certain object.
 * 
 * @param quantity a float variable representing the quantity to be set. This method sets the value of
 * the instance variable "quantity" to the value passed as a parameter.
 */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
