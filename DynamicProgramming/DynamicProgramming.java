package Workout_DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// Задача по утаптыванию в рюкзак предметов с наибольшей суммарной стоимостью
public class DynamicProgramming {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Guitar", 1500, 1));
        items.add(new Item("Recorder", 3000, 4));
        items.add(new Item("Notebook", 2000, 3));

        for (int i = 0; i < items.size(); i++)
            System.out.println(items.get(i).toString());

    }
}
class Item {
    String itemName = new String();
    int itemValue;
    int itemWeight;

    public Item(String itemName, int itemValue, int itemWeight) {
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemWeight = itemWeight;
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