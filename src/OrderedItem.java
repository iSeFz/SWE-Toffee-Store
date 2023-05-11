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

    OrderedItem(){
        quantity = 0;
        currentPrice = 0;
    }

    public float calcPrice() {
        return currentPrice * quantity;
    }
}
