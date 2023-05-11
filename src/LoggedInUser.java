

import java.util.ArrayList;
import java.util.Scanner;

public class LoggedInUser extends GeneralUser {
    private Account account;
    private Address address;
    private boolean isSuspended = false;

    private Order order;

    public LoggedInUser(Account account){
        this.account = account;
    }
    public LoggedInUser(Account account, Address address, boolean isSuspended){
        this.account = account;
        this.address = address;
        this.isSuspended = isSuspended;
    }
    public boolean checkOut(){
        Order order = new Order(cart);
        System.out.println("Order Total Price is: " + order.getTotalPrice());
        this.setOrderDetails();
        System.out.println(order.showOrderInfo());
        System.out.println("Press Y to confirm order: ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")){
            return order.pay(order.getTotalPrice());
        }
        return false;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isSuspended(){
        return isSuspended;
    }
    public Account getAccount(){
        return account;
    }

    public void setOrderDetails() {
        address.fillAddress();
        order.setAddress(address);
        System.out.println("Selected Payment Method: ");
        System.out.println("1. COD\n2. E-Wallet\nEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                order.setPaymentMethod(new COD());
                break;
            case 2:
                break;
        }
    }
}
