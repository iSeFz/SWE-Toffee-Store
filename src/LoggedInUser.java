

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The `LoggedInUser` class represents a user who is logged in and has access to their account and
 * order information, and includes methods for checking out, getting the user's address and account
 * information, and setting order details.
 */
public class LoggedInUser extends GeneralUser {
    // `private Account account;` is declaring a private instance variable of type `Account` in the
    // `LoggedInUser` class. This variable is used to store the account information of the logged in
    // user.
    private Account account;
    // `private Address address;` is declaring a private instance variable of type `Address` in the
    // `LoggedInUser` class. This variable is used to store the address information of the logged in
    // user.
    private Address address;
    // `private boolean isSuspended = false;` is declaring a private instance variable of type
    // `boolean` in the `LoggedInUser` class and initializing it to `false`. This variable is used to
    // keep track of whether the logged in user's account is suspended or not. If the value of
    // `isSuspended` is `true`, it means the account is suspended, and if it is `false`, it means the
    // account is not suspended.
    private boolean isSuspended = false;

   // `private Order order;` is declaring a private instance variable of type `Order` in the
   // `LoggedInUser` class. This variable is used to store the order information of the logged in user.
   // It is initialized to a new instance of the `Order` class in the constructor of the `LoggedInUser`
   // class. The `checkOut()` method uses this variable to create a new order object and set its
   // payment method.
    private Order order;

// This is a constructor for the `LoggedInUser` class that takes an `Account` object as a parameter. It
// initializes the `account` instance variable of the `LoggedInUser` object to the `Account` object
// passed as a parameter, and initializes the `address` and `order` instance variables to new instances
// of the `Address` and `Order` classes, respectively.
    public LoggedInUser(Account account){
        this.account = account;
        this.address = new Address();
        this.order = new Order();

    }
// This is a no-argument constructor for the `LoggedInUser` class. It initializes the `account`
// instance variable to `null`, and initializes the `address` and `order` instance variables to new
// instances of the `Address` and `Order` classes, respectively. This constructor can be used to create
// a new `LoggedInUser` object without passing any parameters.
    public LoggedInUser(){
        this.account = null;
        this.address = new Address();
        this.order = new Order();
    }
/**
 * The function allows a user to check out their cart by creating an order, displaying the total price,
 * confirming the order, and processing payment.
 * 
 * @return The method is returning a boolean value.
 */
    public boolean checkOut(){
        if(!cart.isEmpty()){
            Order order = new Order(cart, new COD());
            System.out.println("Order Total Price is: " + order.getTotalPrice());
            this.setOrderDetails();
            System.out.println(order.showOrderInfo());
            System.out.print("Press Y to confirm order: ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y")){
                return order.pay(order.getTotalPrice());
            }
            else
                return false;
        }
        System.out.println("Cart is empty cannot check out!");
        return false;
    }

/**
 * The function returns an Address object.
 * 
 * @return An object of type `Address` is being returned.
 */
    public Address getAddress() {
        return address;
    }

/**
 * This function returns a boolean value indicating whether an object is suspended or not.
 * 
 * @return A boolean value representing whether the object is suspended or not.
 */
    public boolean isSuspended(){
        return isSuspended;
    }
/**
 * The function returns an account object.
 * 
 * @return An object of the Account class is being returned.
 */
    public Account getAccount(){
        return account;
    }


/**
 * This function sets the order details including the address and payment method as Cash on Delivery.
 */
    public void setOrderDetails() {
        address.fillAddress();
        order.setAddress(address);
        System.out.println("COD Payment Method Selected");
        order.setPaymentMethod(new COD());
    }
}
