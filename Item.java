public class Item {
    private String name;
    private String category;
    private String description;
    private String imageURL;
    private String brand;
    private float price;
    private float availableKG;
    private int availableUnits;
    private ItemStatus status;
    public Item(String name_, String cat, String description_, String URL, String brand_, float price_, float weight, int units, ItemStatus status_){
        name = name_;
        category = cat;
        description = description_;
        imageURL = URL;
        brand = brand_;
        price = price_;
        availableUnits = units;
        availableKG = weight;
        status = status_;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", brand='" + brand + '\'' +
                ", price=" + price + '}';
    }

    public void displayItem(){
        System.out.println(this.toString());
    }

    public OrderedItem orderItem(float quantity, boolean isKG) {
        if(isKG){
            if(this.availableKG  < quantity){
                System.out.println("Insufficient Quantity!");
                System.out.println("Available quantity is: " + this.availableKG + " Kg");
            }
            else{
                this.availableKG -= quantity;
                return new OrderedItem(this, this.price, quantity, true);
            }
        }
        else{
            if(this.availableUnits < quantity){
                System.out.println("Insufficient Quantity!");
                System.out.println("Available quantity is: " + this.availableUnits + " units");
            }
            else{
                this.availableUnits -= quantity;
                return new OrderedItem(this, this.price, quantity, false);
            }
        }
        return new OrderedItem();
    }

    public String getName() {
        return this.name;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}