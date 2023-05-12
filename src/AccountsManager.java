
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

public class AccountsManager {
    private ArrayList<LoggedInUser> users;
    private ArrayList<GeneralUser> guests;

    public AccountsManager(){
        users = new ArrayList<LoggedInUser>();
        guests = new ArrayList<GeneralUser>();
    }

    public void signUp() throws IOException {
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
            System.out.println("This email is already registered!\nDo you want to login? (Y/N)");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y"))
                login();
        }else {
            String OTP = sendOTP(email);
            if (OTPVerification(OTP)) {
                System.out.println("Registering successful!");
                users.add(user);
                accDataFlush(userName, email, password);
            }else{
                System.out.println("OTP is incorrect!");
            }
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        if (verification(new Account(email, password))) {
            System.out.println("Login successful!");
        }
        else {
            System.out.println("Login failed!");
        }
    }

    public void logOut(Account account) {
        if (verification(account)) {
            users.remove(new LoggedInUser(account));
        }
    }

    public boolean verification(Account account) {
        for (LoggedInUser user : users) {
            if (user.getAccount().getEmail().equals(account.getEmail())
                    && user.getAccount().getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public void addUser(LoggedInUser user) {
        users.add(user);
    }

    public void accDataFlush(String userName, String email, String password) throws IOException {
        FileWriter fw = new FileWriter("data/RegisteredUsers.txt",true);
        PrintWriter pw = new PrintWriter(fw,true);
        pw.println(userName + "," + email + "," + password);
    }

    public String generateOTP() {
        Random random = new Random();
        String OTP = "";
        for (int i = 0; i < 6; i++) {
            OTP += random.nextInt(10);
        }
        return OTP;
    }
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

    public boolean OTPVerification(String OTP) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter OTP code: ");
        String inputOTP = sc.nextLine();
        if (inputOTP.equals(OTP)) {
            return true;
        }
        return false;
    }

    public final Pattern emailRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public  boolean checkEmail(String emailStr) {
        Matcher matcher = emailRegex.matcher(emailStr);
        return matcher.matches();
    }
}