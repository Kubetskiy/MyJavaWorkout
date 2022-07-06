public class Item {
    private final String itemName;
    private final int itemValue;
    private final int itemWeight;

    protected Item(String itemName, int itemPrice, int itemWeight) {
        this.itemName = itemName;
        this.itemValue = itemPrice;
        this.itemWeight = itemWeight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemValue;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemValue=" + itemValue +
                ", itemWeight=" + itemWeight +
                '}';
    }
}
