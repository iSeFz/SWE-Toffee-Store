

import java.util.ArrayList;

public class GeneralUser{
    protected ArrayList<OrderedItem> cart;

    public GeneralUser(){
        cart = new ArrayList<OrderedItem>();
    }
    // Add an item to cart
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
    // View cart items
    public void viewCartItems(){
        for(OrderedItem cartItem : cart){
            System.out.println("Name: " + cartItem.item.getName());
            System.out.println("Quantity: " + cartItem.getQuantity());
            System.out.println("Price: " + cartItem.calcPrice());
        }
    }

    public ArrayList<OrderedItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<OrderedItem> cart) {
        this.cart = cart;
    }

}