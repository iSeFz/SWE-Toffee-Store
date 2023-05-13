import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static AccountsManager accManager = new AccountsManager();
    public static ShoppingManager shopManager = new ShoppingManager();

    // Import accounts from RegisteredUsers.txt into the accManager
    public static void accountParse(String path) throws FileNotFoundException, FileNotFoundException {
        String userName, email, password;
        File file = new File(path);
        Scanner scf = new Scanner(file);
        scf.useDelimiter("[,\n]");
        while(scf.hasNext()){
            userName = scf.next();
            email = scf.next();
            password = scf.next();
            password = password.substring(0,password.length() - 1);
            accManager.addUser(new LoggedInUser(new Account(userName,email, password)));
        }
    }

    // Import items from Items.txt into the shopManager
    public static void itemParse(String path) throws IOException {
        String name, cat, description, brand, imageURL, status;
        float price, availableKG;
        int availableUnits;
        File file = new File(path);
        Scanner scf = new Scanner(file);
        scf.useDelimiter("[,\n]");
        while (scf.hasNext()){
            name = scf.next();
            cat = scf.next();
            description = scf.next();
            brand = scf.next();
            imageURL = scf.next();
            price = scf.nextFloat();
            availableKG = scf.nextFloat();
            availableUnits = scf.nextInt();
            status = scf.next();
            status = status.substring(0,status.length() - 1);
            shopManager.addItem(name, cat, description, imageURL, brand, price, availableKG, availableUnits);
        }
    }

    public static void main(String[] args) throws IOException {
        accountParse("data/RegisteredUsers.txt");
        itemParse("data/Items.txt");
        Scanner choice = new Scanner(System.in);
        int option;
        System.out.println("\tWelcome to our Toffee Shop!");
        while (true) {
            System.out.println("\nOur program offers the following features:\n" +
                    "1. Register a new account\n" +
                    "2. Login to your account\n" +
                    "3. Display Catalog of Items\n" +
                    "4. Shop for Toffees & Add to Cart\n" +
                    "5. View Cart & Checkout\n" +
                    "6. Make an order to be paid through COD (Cash on delivery)\n" +
                    "7. Exit");
            System.out.print("Choose one of the above options >> ");
            option = choice.nextInt();
            if (option == 1)
                accManager.signUp();
            else if (option == 2)
                accManager.login();
            else if (option == 3)
                shopManager.displayCatalog();
            else if (option == 4)
                System.out.println("\n\tShop for Toffees & Add to Cart!");
            else if (option == 5)
                System.out.println("\n\tView Cart & Checkout!");
            else if (option == 6)
                System.out.println("\n\tMake an order to be paid through cash upon delivery!");
            else if (option == 7)
                break;
            else
                System.out.println("\n\tINVALID OPTION! Enter only numbers from 1 to 6");
        }
        choice.close();
        System.out.println("\n\tThank you for using our Toffee Shop!");
    }
}
