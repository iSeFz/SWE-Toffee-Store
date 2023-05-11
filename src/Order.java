

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String number;
    private float totalPrice;
    private Date orderedAt;
    private ArrayList<OrderedItem> cart;
    private Address address;

    private PaymentMethod paymentMethod;

    public Order(ArrayList<OrderedItem> cart){
        this.cart = cart;
    }

    public float getTotalPrice(){

        return this.totalPrice;
    }
    public void setPaymentMethod(PaymentMethod method){
        this.paymentMethod = method;
        paymentMethod.takePhone();
    }

    public String showOrderInfo(){
        return "Order{" +
                "number=" + number +
                ", totalPrice=" + totalPrice +
                ", orderedAt=" + orderedAt +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone){
        this.number = phone;
    }
//    public void setAddress(Address add){}
    public boolean pay(float amount){
        return paymentMethod.pay(amount);
    }


}