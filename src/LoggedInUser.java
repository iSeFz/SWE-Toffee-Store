

import java.util.ArrayList;
import java.util.Scanner;

public class LoggedInUser extends GeneralUser {
    private Account account;
    private Address address;
    private boolean isSuspended = false;

    private Order order;

    public LoggedInUser(Account account){
        this.account = account;
        this.address = new Address();
        this.order = new Order();

    }
    public LoggedInUser(){
        this.account = null;
        this.address = new Address();
        this.order = new Order();
    }
    public boolean checkOut(){
        Order order = new Order(cart, new COD());
        System.out.println("Order Total Price is: " + order.getTotalPrice());
        this.setOrderDetails();
        System.out.println(order.showOrderInfo());
        System.out.print("Press Y to confirm order: ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")){
            return order.pay(order.getTotalPrice());
        }
        else
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
//        address.fillAddress();
//        order.setAddress(address);
        System.out.println("COD Payment Method Selected");
        order.setPaymentMethod(new COD());
    }
}
