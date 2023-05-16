package Accounts;

/**
 * The `Account` class is a Java class that represents a user account and contains methods to set and
 * retrieve the account's username, email, and password.
 */
public class Account {
    // `private String userName;` is declaring a private instance variable of type String named
    // `userName` in the `Account` class. This variable can only be accessed within the `Account` class
    // and not from outside the class.
    private String userName;
    // `private String email;` is declaring a private instance variable of type String named `email` in
    // the `Account` class. This variable can only be accessed within the `Account` class and not from
    // outside the class. It is used to store the email address associated with the account.
    private String email;
    // `private String password;` is declaring a private instance variable of type String named
    // `password` in the `Account` class. This variable can only be accessed within the `Account` class
    // and not from outside the class. It is used to store the password associated with the account.
    private String password;

// This is a constructor method for the `Account` class that takes in three parameters: `userName`,
// `email`, and `password`. When an object of the `Account` class is created using this constructor,
// the `userName`, `email`, and `password` instance variables of the object are set to the values
// passed in as arguments. The `this` keyword is used to refer to the instance variables of the object
// being created.
    public Account(String userName,String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

// This is another constructor method for the `Account` class that takes in two parameters: `email` and
// `password`. When an object of the `Account` class is created using this constructor, the `email` and
// `password` instance variables of the object are set to the values passed in as arguments. The
// `userName` instance variable is not set in this constructor, so it will be null. This constructor
// can be used when the user does not provide a username during account creation.
    public Account(String email, String password){
        this.email = email;
        this.password = password;
    }
/**
 * The function sets the user's name, email, and password and returns true.
 * 
 * @param name A string representing the user's name.
 * @param mail The "mail" parameter is a String variable that represents the email address of the user.
 * @param pass pass is a String parameter that represents the password to be set for a user's account.
 * @return A boolean value of true is being returned.
 */
    public boolean setInfo(String name, String mail, String pass){
        this.userName = name;
        this.email = mail;
        this.password = pass;
        return true;
    }
/**
 * This Java function returns the username.
 * 
 * @return The method `getUserName()` is returning a `String` which represents the `userName` of the
 * object.
 */

    public String getUserName(){
        return this.userName;
    }
/**
 * This function returns the email of an object.
 * 
 * @return The method `getEmail()` is returning the email address as a String.
 */
    public String getEmail(){
        return this.email;
    }
/**
 * This function returns the password of an object.
 * 
 * @return The method `getPassword()` is returning the value of the `password` variable.
 */
    public String getPassword(){
        return this.password;
    }
}
