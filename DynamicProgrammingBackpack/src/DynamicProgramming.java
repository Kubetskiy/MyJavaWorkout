// Задача по утаптыванию в рюкзак предметов с наибольшей суммарной стоимостью
public class DynamicProgramming {

    public static void main(String[] args) {
//массив вещей
        Item[] items = {new Item("гитара", 1500, 1),
                new Item("бензопила", 3000, 4),
                new Item("ноутбук", 2000, 3),
                new Item("iPad", 2000, 1)};

        int weight = 4; //грузоподъёмность рюкзака

        //массив промежуточных состояний рюкзака, первая колонка для удобства и наглядности нули
        BackPack[][] bp = new BackPack[items.length][weight + 1];

        // первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от веса
        for (int j = 1; j <= weight; j++) {
            bp[0][j] = items[0].getItemWeight() <= j ? // Предмет проходит по весу
                    new BackPack(new Item[]{items[0]}, items[0].getItemPrice()) // Заполняем ячейку
                    : new BackPack(new Item[]{}, 0); // пустышка
//            System.out.println(bp[0][j].getDescription());
        }

        for (int i = 1; i < items.length; i++) {
            for (int j = 1; j <= weight; j++) {
                if (items[i].getItemWeight() > j) {
                    bp[i][j] = bp[i - 1][j]; // Копируем с предыдущей строки
                    continue;
                }
                // Стоимость предмета плюс стоимость, которую можно положить в свободнуе ячейки
                int newPrice = (items[i].getItemWeight() < j) ?
                        items[i].getItemPrice() + bp[i-1][j - items[i].getItemWeight()].getPrice() :
                        items[i].getItemPrice();

                if (newPrice <= bp[i - 1][j].getPrice()) {
                    bp[i][j] = bp[i - 1][j];
                } else {
                    bp[i][j] = (items[i].getItemWeight() < j) ?
                            (new BackPack(itemConcatenate(bp[i-1][j - items[i].getItemWeight()].getItems() ,items[i]),
                            items[i].getItemPrice() + bp[i-1][j - items[i].getItemWeight()].getPrice())) :
                            (new BackPack(new Item[]{items[i]}, items[i].getItemPrice()));
                }
            }
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = 1; j <= weight; j++) {
                System.out.print(bp[i][j].getDescription() + " ");
            }
            System.out.print("\n");
        }

    }
    private static Item[] itemConcatenate(Item[] Items, Item item) {
        Item[] result = new Item[Items.length + 1];
        for (int i = 0; i < Items.length; i++) {
            result[i] = Items[i];
        }
        result[result.length - 1] = item;
        return result;
    }
}
