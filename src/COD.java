

import java.util.Scanner;

public class COD extends PaymentMethod {
    private String phone;

    COD(){
        this.phone = "";
    }
    COD(COD paymentMethod){
        this.phone = paymentMethod.phone;
    }
    @Override
    public boolean pay(float amount) {
        return false;
    }

    public void takePhone(){
        System.out.println("Enter Phone Number: ");
        Scanner sc = new Scanner(System.in);
        String phoneNum = sc.nextLine();
        this.setPhone(phoneNum);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
