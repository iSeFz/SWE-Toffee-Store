import java.util.ArrayList;
import java.util.Date;

public class Order {
    String number;
    float totalPrice;
    Date orderedAt;
    ArrayList<OrderedItem> cart;
//    Address address;
    public float getTotalPrice(){

        return this.totalPrice;
    }
    public void setPaymentMethod(PaymentMethod choice){}

    public String showOrderInfo(){
        return "Order{" +
                "number=" + number +
                ", totalPrice=" + totalPrice +
                ", orderedAt=" + orderedAt +
                '}';
    }
    public void setPhone(String phone){
        this.number = phone;
    }
//    public void setAddress(Address add){}
    public boolean pay(float amount){
        return false;
    }


}