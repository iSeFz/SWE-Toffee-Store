

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class Order {
    private String number;
    private float totalPrice;
    private String orderedAt;
    private ArrayList<OrderedItem> cart;
    private Address address;

    private PaymentMethod paymentMethod;

    public Order(){
        this.cart = new ArrayList<OrderedItem>();
        orderedAt = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public Order(ArrayList<OrderedItem> cart, PaymentMethod payment){
        this.paymentMethod = payment;
        this.cart = cart;
        for (OrderedItem item : cart)
           totalPrice += item.calcPrice();
        Random random = new Random();
        number = "TOF#" + random.nextInt(10000);
        orderedAt = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public float getTotalPrice(){

        return this.totalPrice;
    }
    public void setPaymentMethod(PaymentMethod method){
        this.paymentMethod = method;
        paymentMethod.takePhone();
    }

    public String showOrderInfo(){
        return "[Order Number: " + number +
                ", Total Price: " + totalPrice +
                ", Order Time: " + orderedAt + ']';
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void setPhone(String phone){
        this.number = phone;
    }
    public boolean pay(float amount){
        return paymentMethod.pay(amount);
    }
}