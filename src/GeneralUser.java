

import java.util.ArrayList;

public class GeneralUser{
    protected ArrayList<OrderedItem> cart;
    // Add an item to cart
    public void addToCart(Item item, float quantity, boolean type){
        cart.add(item.orderItem(quantity, type));
    }
    // View cart items
    public void viewCartItems(){
        for(OrderedItem cartItem : cart){
            System.out.println("Name: " + cartItem.item.getName());
            System.out.println("Quantity: " + cartItem.quantity);
            System.out.println("Price: " + cartItem.calcPrice());
        }
    }

}