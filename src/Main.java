import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        int option;
        System.out.println("\tWelcome to our Toffee Shop!");
        while (true) {
            System.out.println("\nOur program offers the following features:\n" +
                    "1. Register a new account\n" +
                    "2. Login to your account\n" +
                    "3. Display Catalog of Toffees\n" +
                    "4. Shop for Toffees\n" +
                    "5. Make an order to be paid through COD (Cash on delivery)\n" +
                    "6. Exit");
            System.out.print("Choose one of the above options >> ");
            option = choice.nextInt();
            // Register a new account
            if (option == 1)
                System.out.println("\n\tRegister a new account!");
            // Login to your account
            else if (option == 2)
                System.out.println("\n\tLogin to your account!");
            // Display Catalog of Toffees
            else if (option == 3)
                System.out.println("\n\tDisplay Catalog of Toffees!");
            // Shop for Toffees & add them to cart
            else if (option == 4)
                System.out.println("\n\tShop for Toffees!");
            // Make an order to be paid through cash upon delivery
            else if (option == 5)
                System.out.println("\n\tMake an order to be paid through cash upon delivery!");
            else if (option == 6)
                break;
            else
                System.out.println("\n\tINVALID OPTION! Enter only numbers from 1 to 6");
        }
        choice.close();
        System.out.println("\n\tThank you for using our Toffee Shop!");
    }
}
