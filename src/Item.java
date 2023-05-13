

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

    // Constructor
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

    // Display item details
    public void displayItem(){
        System.out.println("[Name: '" + name +
        "', Category: " + category +
        ", Brand: '" + brand +
        "', Price: " + price + "]");
    }

    // Check for item availability
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

    // Getters & Setters
    public String getName() { return this.name; }
    public ItemStatus getStatus() { return status; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getImageURL() { return imageURL; }
    public String getBrand() { return brand; }
    public float getPrice() { return price; }
    public float getAvailableKG() { return availableKG; }
    public int getAvailableUnits() { return availableUnits; }
    public void setStatus(ItemStatus status) { this.status = status; }
}


