package Inventory;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The COD class is a subclass of PaymentMethod that stores a phone number and allows for payment
 * through cash on delivery.
 */
public class COD extends PaymentMethod {
    // `private String phone;` is declaring a private instance variable `phone` of type `String` in the
    // `COD` class. This variable is used to store the phone number of the customer who is using the
    // COD payment method.
    private String phone;

// The `COD()` method is a constructor for the `COD` class. It initializes a new instance of the `COD`
// class with an empty string for the `phone` instance variable.
public COD(){
        this.phone = "";
    }
    // The `COD(COD paymentMethod)` is a constructor for the `COD` class that takes an instance of the
    // `COD` class as a parameter. It initializes a new instance of the `COD` class with the same
    // `phone` value as the `paymentMethod` instance. This constructor is used to create a new instance
    // of the `COD` class with the same `phone` value as an existing instance of the `COD` class.
    COD(COD paymentMethod){ this.phone = paymentMethod.phone; }
/**
 * The function always returns true when called with a float parameter.
 * 
 * @param amount The amount of money that is being paid.
 * @return A boolean value of true is being returned.
 */
    @Override
    public boolean pay(float amount) { return true; }

/**
 * This Java function takes user input for a phone number and sets it as an object's phone number
 * attribute.
 */
    public void takePhone(){
        Scanner sc = new Scanner(System.in);
        String phoneRegex = "^(012|011|015|010)\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        System.out.print("Enter Phone Number: ");
        String phoneNum = sc.nextLine();
        while(!pattern.matcher(phoneNum).matches()){
            System.out.print("Please enter phone number start with (012,010,011,015) and contain 11 digits: ");
            phoneNum = sc.nextLine();
        }
        this.setPhone(phoneNum);
    }
    /**
     * This is a Java function that sets the value of a phone variable.
     * 
     * @param phone The parameter "phone" is a String type variable that is being passed as an argument
     * to the method "setPhone". The method sets the value of the instance variable "phone" to the
     * value of the parameter "phone".
     */
    public void setPhone(String phone) { this.phone = phone; }
}
