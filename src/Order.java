

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

/**
 * The Order class represents an order with a number, total price, ordered time, list of items,
 * address, and payment method, and includes methods for setting and getting these attributes,
 * displaying order information, and processing payments.
 */
public class Order {
    // `private String number;` is declaring a private instance variable `number` of type `String` in
    // the `Order` class. This variable is used to store the order number for each order.
    private String number;
    // `private float totalPrice;` is declaring a private instance variable `totalPrice` of type
    // `float` in the `Order` class. This variable is used to store the total price of the order, which
    // is calculated by adding up the prices of all the items in the order.
    private float totalPrice;
    // `private String orderedAt;` is declaring a private instance variable `orderedAt` of type
    // `String` in the `Order` class. This variable is used to store the date and time when the order
    // was placed, which is generated using the `SimpleDateFormat` class and the `Calendar` class. It
    // is used to display the order time in the `showOrderInfo()` method.
    private String orderedAt;
    // `private ArrayList<OrderedItem> cart;` is declaring a private instance variable `cart` of type
    // `ArrayList<OrderedItem>` in the `Order` class. This variable is used to store the list of items
    // that are part of the order. Each item in the list is an instance of the `OrderedItem` class. The
    // `cart` variable is initialized in the constructor of the `Order` class. It is used to calculate
    // the total price of the order and to display the list of items in the order in the
    // `showOrderInfo()` method.
    private ArrayList<OrderedItem> cart;
    // `private Address address;` is declaring a private instance variable `address` of type `Address`
    // in the `Order` class. This variable is used to store the address of the customer who placed the
    // order. It is set using the `setAddress()` method and can be accessed using getter methods. The
    // address is used to deliver the order to the customer.
    private Address address;

    // `private PaymentMethod paymentMethod;` is declaring a private instance variable `paymentMethod`
    // of type `PaymentMethod` in the `Order` class. This variable is used to store the payment method
    // that the customer has chosen to pay for the order. It is set using the `setPaymentMethod()`
    // method and can be accessed using getter methods. The `paymentMethod` variable is used to process
    // the payment for the order using the `pay()` method.
    private PaymentMethod paymentMethod;

// This is a constructor method for the `Order` class that initializes a new instance of the class with
// an empty `cart` ArrayList and sets the `orderedAt` variable to the current date and time in the
// format "yyyyMMdd_HHmmss". This constructor does not take any arguments.
    public Order(){
        this.cart = new ArrayList<OrderedItem>();
        orderedAt = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

// This is a constructor method for the `Order` class that takes two arguments: an `ArrayList` of
// `OrderedItem` objects called `cart` and a `PaymentMethod` object called `payment`.
    public Order(ArrayList<OrderedItem> cart, PaymentMethod payment){
        this.paymentMethod = payment;
        this.cart = cart;
        for (OrderedItem item : cart)
           totalPrice += item.calcPrice();
        Random random = new Random();
        number = "TOF#" + random.nextInt(10000);
        orderedAt = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss").format(Calendar.getInstance().getTime());
    }

/**
 * The function returns the total price as a float value.
 * 
 * @return The method `getTotalPrice()` is returning a float value which represents the total price.
 */
    public float getTotalPrice(){

        return this.totalPrice;
    }
/**
 * This function sets the payment method and calls the takePhone() method of the payment method object.
 * 
 * @param method The parameter "method" is of type PaymentMethod, which is an object representing a
 * payment method. This method is used to set the payment method for a transaction and then call the
 * "takePhone()" method on the payment method object.
 */
    public void setPaymentMethod(PaymentMethod method){
        this.paymentMethod = method;
        paymentMethod.takePhone();
    }

/**
 * The function returns a string containing order information such as order number, total price, and
 * order time.
 * 
 * @return The method `showOrderInfo()` is returning a string that contains the order number, total
 * price, and order time of an order. The string is formatted as follows:
 */
    public String showOrderInfo(){
        return "[Order Number: " + number +
                ", Total Price: " + totalPrice +
                ", Order Time: " + orderedAt + ']';
    }
/**
 * This function sets the address of an object.
 * 
 * @param address The parameter "address" is an object of the class "Address". The method "setAddress"
 * sets the value of the instance variable "address" to the value of the parameter "address".
 */

    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * The function sets the phone number for an object.
     * 
     * @param phone The parameter "phone" is a String variable that represents a phone number. The
     * method "setPhone" sets the value of the instance variable "number" to the value of the "phone"
     * parameter.
     */
    public void setPhone(String phone){
        this.number = phone;
    }
/**
 * The function "pay" takes a float amount and returns a boolean indicating whether the payment was
 * successful using a payment method.
 * 
 * @param amount a float value representing the amount of money to be paid.
 * @return A boolean value is being returned.
 */
    public boolean pay(float amount){
        return paymentMethod.pay(amount);
    }
}