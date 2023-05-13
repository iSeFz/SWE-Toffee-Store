

public class OrderedItem {
    Item item;
    float currentPrice;
    float quantity;
    boolean isKG;

    public OrderedItem(Item item, float currentPrice, float quantity, boolean isKG) {
        this.item = item;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.isKG = isKG;
    }

    public OrderedItem() {
        quantity = 0;
        currentPrice = 0;
    }

    public float calcPrice() {
        return currentPrice * quantity;
    }

    // Getters
    public float getQuantity() { return quantity; }
    public Item getItem() { return item; }
    public boolean getType() { return isKG; }

    // Setters
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
