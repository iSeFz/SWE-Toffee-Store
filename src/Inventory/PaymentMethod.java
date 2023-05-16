package Inventory;

/**
 * The PaymentMethod class is an abstract class with two abstract methods, one for making payments and
 * one for taking a phone.
 */

public abstract class PaymentMethod {
    /**
     * This is an abstract method that returns a boolean value indicating whether a payment of a
     * specified amount was successful or not.
     * 
     * @param amount The "amount" parameter is a floating-point number that represents the amount of
     * money to be paid. The method is abstract, which means that it does not have an implementation in
     * this class and must be implemented by any concrete subclass that extends this abstract class.
     * The method returns a boolean value indicating whether the
     * @return A boolean value is being returned.
     */
    public abstract boolean pay(float amount);

    /**
     * This is an abstract method that does not have a body and requires any class that implements it
     * to define its own implementation of the method.
     */
    public abstract void takePhone();
}
