
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        LoggedInUser user = new LoggedInUser(new Account(userName, email, password + "\r"));
        if(verification(user.getAccount())){
            System.out.println("This email is already registered!\nDo you want to login? (Y/N)");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y"))
                login();
        }else {
            users.add(user);
            accDataFlush(userName, email, password);
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
        sc.close();
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

}