import java.util.StringJoiner;

public class BackPack {
    private Item[] items;
    private int price;

    public BackPack(Item[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public Item[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }

    //Описание состояния рюкзака
    public String getDescription() {
        if (items == null) {
            return "";
        } else {
            StringJoiner joiner = new StringJoiner("+");
            for (Item item : items) {
                String itemName = item.getItemName();
                joiner.add(itemName);
            }
            return joiner.toString() +
                            "-" + getPrice();
        }
    }
}