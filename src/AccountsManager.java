
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.mail.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 * The AccountsManager class manages user accounts, including sign up, login, verification, and OTP
 * generation and verification.
 */
public class AccountsManager {
    // This line of code is declaring a regular expression pattern for email validation. The pattern is
    // stored in a `Pattern` object named `emailRegex`. The regular expression pattern is
    // `^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$`, which matches email addresses that start with one
    // or more uppercase letters, digits, dots, underscores, percent signs, plus signs, or hyphens,
    // followed by an at symbol (@), followed by one or more uppercase letters, digits, dots, or
    // hyphens, followed by a dot (.), followed by two to six uppercase letters. The
    // `Pattern.CASE_INSENSITIVE` flag is used to make the pattern case-insensitive. This pattern is
    // used in the `checkEmail` method to validate email addresses.
    public final Pattern emailRegex =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    // `private ArrayList<LoggedInUser> users;` is declaring a private instance variable `users` of
    // type `ArrayList<LoggedInUser>`. This variable is used to store a list of `LoggedInUser` objects,
    // which represent users who have signed up and logged in to the system.
    private ArrayList<LoggedInUser> users;
    // `private ArrayList<GeneralUser> guests;` is declaring a private instance variable `guests` of
    // type `ArrayList<GeneralUser>`. This variable is used to store a list of `GeneralUser` objects,
    // which represent users who have not signed up or logged in to the system and are browsing the
    // website as guests.
    private ArrayList<GeneralUser> guests;
    // `private ShoppingManager shoppingManager;` is declaring a private instance variable
    // `shoppingManager` of type `ShoppingManager`. This variable is used to store an instance of the
    // `ShoppingManager` class, which is passed as a parameter to the constructor of the
    // `AccountsManager` class. This allows the `AccountsManager` class to access and use the methods
    // and variables of the `ShoppingManager` class.
    private ShoppingManager shoppingManager;

// This is a constructor for the `AccountsManager` class that takes a parameter of type
// `ShoppingManager`. It initializes the `users` and `guests` instance variables as new empty
// `ArrayList`s of `LoggedInUser` and `GeneralUser` objects, respectively. It also sets the
// `shoppingManager` instance variable to the `shoppingManager` parameter passed to the constructor and
// calls the `setAccountsManager` method of the `shoppingManager` object, passing `this` (the current
// `AccountsManager` object) as a parameter. This allows the `ShoppingManager` class to access and use
// the methods and variables of the `AccountsManager` class.
    public AccountsManager(ShoppingManager shoppingManager){
        users = new ArrayList<LoggedInUser>();
        guests = new ArrayList<GeneralUser>();
        this.shoppingManager = shoppingManager;
        shoppingManager.setAccountsManager(this);
    }

   /**
    * The function allows a user to sign up by inputting their name, email, and password, and verifies
    * their email and OTP before adding them to the list of users and logging them in.
    * 
    * @return The method is returning a LoggedInUser object.
    */
    public LoggedInUser signUp() throws IOException {
        System.out.println("\n\tRegister new account");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        while (!checkEmail(email)) {
            System.out.print("Please enter your email as example@gmail.com: ");
            email = sc.nextLine();
        }
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        LoggedInUser user = new LoggedInUser(new Account(userName, email, password));
        if(verification(user.getAccount())){
            System.out.print("This email is already registered!\nDo you want to login? (Y/N) ");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y"))
                return login();
        }else {
            String OTP = sendOTP(email);
            if (OTPVerification(OTP)) {
                System.out.println("Registration successful!");
                users.add(user);
                accDataFlush(userName, email, password);
                login();
            }else{
                System.out.println("OTP is incorrect!");
                signUp();
            }
        }
        return user;
    }

/**
 * The function takes user input for email and password, creates an account object, verifies the
 * account, and returns a LoggedInUser object if successful.
 * 
 * @return A LoggedInUser object is being returned. If the verification of the user's email and
 * password is successful, a new LoggedInUser object is created with the user's account information. If
 * the verification fails, an empty LoggedInUser object is returned.
 */
    public LoggedInUser login() {
        System.out.println("\n\tLogin To Your Account");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        Account user = new  Account(email, password);
        if (verification(user)) {
            System.out.println("Login successful!");
            return new LoggedInUser(user);
        }
        else
            System.out.println("Login failed!");
        return new LoggedInUser();
    }

/**
 * The function checks if an account's email and password match with any of the logged in users' email
 * and password.
 * 
 * @param account An object of the class Account, which contains the email and password of a user
 * trying to log in.
 * @return The method is returning a boolean value. It returns true if the email and password of the
 * given account match with any of the email and password of the accounts stored in the users list,
 * otherwise it returns false.
 */
    public boolean verification(Account account) {
        for (LoggedInUser user : users) {
            if (user.getAccount().getEmail().equals(account.getEmail())) {
                if(user.getAccount().getPassword().equals(account.getPassword()))
                    return true;
                else{
                    System.out.println("Password is incorrect");
                    return false;
                }
            }
        }
        return false;
    }
/**
 * This function adds a LoggedInUser object to a list of users.
 * 
 * @param user The parameter "user" is an object of the class "LoggedInUser" that is being passed as an
 * argument to the method "addUser". This method adds the user object to a collection of users.
 */
    public void addUser(LoggedInUser user) {
        users.add(user);
    }

/**
 * This function writes user account data (username, email, and password) to a file.
 * 
 * @param userName The username of the user being registered.
 * @param email The email parameter is a string variable that represents the email address of a
 * registered user.
 * @param password The password parameter is a String variable that represents the password of a user.
 * It is used as an input parameter for the accDataFlush method, which writes the user's information
 * (including their password) to a file.
 */
    public void accDataFlush(String userName, String email, String password) throws IOException {
        FileWriter fw = new FileWriter("data/RegisteredUsers.txt",true);
        PrintWriter pw = new PrintWriter(fw,true);
        pw.println(userName + "," + email + "," + password);
    }

/**
 * This Java function generates a 6-digit random OTP (one-time password) using numbers 0-9.
 * 
 * @return The method is returning a randomly generated 6-digit OTP (One-Time Password) as a String.
 */
    public String generateOTP() {
        Random random = new Random();
        String OTP = "";
        for (int i = 0; i < 6; i++) {
            OTP += random.nextInt(10);
        }
        return OTP;
    }
   /**
    * The function sends an email containing a generated OTP to a specified recipient using Gmail's
    * SMTP server.
    * 
    * @param recipient The email address of the recipient who will receive the OTP.
    * @return The method is returning a String which is the OTP (One Time Password) generated and sent
    * to the recipient's email address.
    */
    public String sendOTP(String recipient) {
        String sender = "mohamedamgad233@gmail.com";
        String OTP = generateOTP();

        // Getting system properties
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mohamedamgad233@gmail.com", "uqprhagqtrgpcbnp");
            }
        };

        // creating session object to get properties
        Session session = Session.getInstance(properties, auth);

        try {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("Toffee: OTP Request");

            // set body of the email.
            message.setText("Hi, \n\n\n Here is the OTP you have requested: " + OTP);

            // Send email.
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return OTP;
    }

/**
 * The function takes user input for an OTP code and returns true if it matches the given OTP.
 * 
 * @param OTP The OTP parameter is a string representing the One-Time Password that needs to be
 * verified.
 * @return A boolean value is being returned. It will be true if the input OTP matches the OTP passed
 * as a parameter, and false otherwise.
 */
    public boolean OTPVerification(String OTP) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter OTP code: ");
        String inputOTP = sc.nextLine();
        if (inputOTP.equals(OTP)) {
            return true;
        }
        return false;
    }

/**
 * The function checks if a given string matches the pattern of a valid email address.
 * 
 * @param emailStr The email address that needs to be checked for validity.
 * @return A boolean value indicating whether the input string matches the email regular expression
 * pattern.
 */
    public  boolean checkEmail(String emailStr) {
        Matcher matcher = emailRegex.matcher(emailStr);
        return matcher.matches();
    }
}