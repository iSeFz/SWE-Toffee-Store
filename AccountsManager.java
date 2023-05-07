import java.util.ArrayList;
import java.util.Scanner;

public class AccountsManager {
    private ArrayList<LoggedInUser> users;
    // private ArrayList<GeneralUser> guests;

    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        users.add(new LoggedInUser(new Account(email, password)));
        sc.close();
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
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
}