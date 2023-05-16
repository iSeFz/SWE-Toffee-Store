

import java.util.ArrayList;

/**
 * The GeneralUser class represents a user who can add items to their shopping cart, view their cart,
 * and manage the contents of their cart.
 */
public class GeneralUser{
    // `protected ArrayList<OrderedItem> cart;` is declaring an instance variable `cart` of type
    // `ArrayList<OrderedItem>` with protected access modifier. This means that the variable can be
    // accessed within the class and its subclasses, but not from outside the class. The `ArrayList`
    // will be used to store `OrderedItem` objects that a `GeneralUser` adds to their cart.
    protected ArrayList<OrderedItem> cart;

// `public GeneralUser()` is a constructor method for the `GeneralUser` class. When a new instance of
// the `GeneralUser` class is created, this constructor is called automatically.
    public GeneralUser(){
        cart = new ArrayList<OrderedItem>();
    }
    /**
     * The function adds an ordered item to a cart, and if the item already
     * exists in the cart, it updates the quantity of the existing item.
     * 
     * @param oItem an object of the class OrderedItem that represents an item
     * that a customer wants to add to their shopping cart. It contains
     * information such as the item's name, type, and quantity.
     */
    
/**
 * The function adds an ordered item to a cart, and if the item already exists in the cart, it updates
 * the quantity of the existing item.
 * 
 * @param oItem The parameter "oItem" is an object of the class "OrderedItem" which represents an item
 * that a customer has ordered. It contains information such as the item's name, type, quantity, and
 * price. The method "addToCart" adds this item to the customer's shopping cart.
 */
    public void addToCart(OrderedItem oItem){
        boolean notAdded = true;
        for(OrderedItem cartItem : cart){
            if(cartItem.getItem().getName().equals(oItem.getItem().getName()) && cartItem.getType() == oItem.getType()) {
                oItem.setQuantity(oItem.getQuantity() + cartItem.getQuantity());
                cart.remove(cartItem);
                cart.add(oItem);
                notAdded = false;
                break;
            }
        }
        if(notAdded)
            cart.add(oItem);
    }
    
/**
 * The function displays the name, quantity, and price of each item in the cart.
 */
    public void viewCartItems(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty nothing to view!");
            return;
        }
        System.out.println("\n\tYour Cart Items");
        for(OrderedItem cartItem : cart){
            System.out.println("Name: " + cartItem.item.getName());
            if(cartItem.getType()){
                System.out.println("Quantity: " + cartItem.getQuantity() + " Kg");
            }
            else
                System.out.println("Quantity: " + (int)cartItem.getQuantity() + " Units");
            System.out.println("Price: " + cartItem.calcPrice());
        }
    }

/**
 * This function returns an ArrayList of OrderedItem objects representing the items in the user's cart.
 * 
 * @return An ArrayList of OrderedItem objects named "cart".
 */
    public ArrayList<OrderedItem> getCart() {
        return cart;
    }

/**
 * This function sets the cart ArrayList of OrderedItem objects for a Java class.
 * 
 * @param cart An ArrayList of OrderedItem objects that represents the shopping cart of a customer.
 * This method sets the value of the cart instance variable of an object to the provided ArrayList.
 */
    public void setCart(ArrayList<OrderedItem> cart) {
        this.cart = cart;
    }

}