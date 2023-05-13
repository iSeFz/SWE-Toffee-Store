import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static ShoppingManager shopManager = new ShoppingManager();
    public static AccountsManager accManager = new AccountsManager(shopManager);

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
        scf.useDelimiter("[,\n\r]");
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

    public static void subMenu(int index) throws IOException {
        LoggedInUser lUser = new LoggedInUser();
        GeneralUser gUser = new GeneralUser();
        if (index == 1)
            lUser = accManager.signUp();
        else if(index == 2)
            accManager.login();
        Scanner choice = new Scanner(System.in);
        while(true) {
            System.out.println("\nOur program offers the following features:\n" +
                    "1. Display Catalog of Items\n" +
                    "2. Shop for Toffees & Add to Cart\n" +
                    "3. View cart of ordered items\n" +
                    "4. Make an order to be paid through COD (Cash on delivery)\n" +
                    "5. Exit"
            );
            System.out.print("Choose one of the above options >> ");
            int option = choice.nextInt();
            if (option == 1)
                shopManager.displayCatalog();
            else if (option == 2)
                if(index == 3)
                    shopManager.orderItem(gUser);
                else
                    shopManager.orderItem(lUser);
            else if (option == 3)
                lUser.viewCartItems();
            else if (option == 4) {
                if(index == 3) {
                    System.out.println("To Checkout You Must Register First!");
                    lUser = accManager.signUp();
                    lUser.setCart(gUser.getCart());
                }
                if(lUser.checkOut())
                    System.out.println("\n\tPayment Successfull!");
            }
            else if (option == 5)
                break;
            else
                System.out.println("\n\tINVALID OPTION! Enter only numbers from 1 to 6");
        }
    }

    public static void main(String[] args) throws IOException {
        accountParse("data/RegisteredUsers.txt");
        itemParse("data/Items.txt");
        Scanner choice = new Scanner(System.in);
        int option;
        System.out.println("\tWelcome to our Toffee Shop!");
        while (true) {
            // Guest menu
            System.out.println("1. Register a new account\n" +
                    "2. Login to your account\n" +
                    "3. Continue as guest\n" +
                    "4. Exit");
            System.out.print("Choose one of the above options >> ");
            option = choice.nextInt();
            if (option == 1)
                subMenu(1);
            else if (option == 2)
                subMenu(2);
            else if (option == 3)
                subMenu(3);
            else if(option == 4) break;
            else
                System.out.println("\n\tINVALID OPTION! Enter only numbers from 1 to 6");
        }
        choice.close();
        System.out.println("\n\tThank you for using our Toffee Shop!");
    }
}