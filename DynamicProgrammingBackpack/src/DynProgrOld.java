import java.util.Arrays;
import java.util.stream.Stream;

public class DynProgrOld {
    public static void main(String[] args) {
//массив вещей
        Item[] items = {new Item("гитара", 1500, 1),
                new Item("бензопила", 3000, 4),
                new Item("ноутбук", 2000, 3)};
//                new Item("iPad", 2000, 1)};
        int n = 3;
        int weight = 4; //грузоподъёмность рюкзака
        int k = 4;

        //массив промежуточных состояний рюкзака, первая колонка для удобства и наглядности нули
        BackPack[][] bp = new BackPack[items.length + 1][weight + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    bp[i][j] = new BackPack(new Item[]{}, 0);
                } else if (i == 1) {
                    /*первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от веса*/
                    bp[1][j] = items[0].getItemWeight() <= j ? new BackPack(new Item[]{items[0]}, items[0].getItemPrice())
                            : new BackPack(new Item[]{}, 0);
                } else {
                    if (items[i - 1].getItemWeight() > j) //если очередной предмет не влезает в рюкзак,
                        bp[i][j] = bp[i - 1][j];    //записываем предыдущий максимум
                    else {
                        /*рассчитаем цену очередного предмета + максимальную цену для (максимально возможный для рюкзака вес − вес предмета)*/
                        int newPrice = items[i - 1].getItemPrice() + bp[i - 1][j - items[i - 1].getItemPrice()].getPrice();
                        if (bp[i - 1][j].getPrice() > newPrice) //если предыдущий максимум больше
                            bp[i][j] = bp[i - 1][j]; //запишем его
                        else {
                            /*иначе фиксируем новый максимум: текущий предмет + стоимость свободного пространства*/
                            bp[i][j] = new BackPack(Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                    Arrays.stream(bp[i - 1][j - items[i - 1].getItemPrice()].getItems())).toArray(Item[]::new), newPrice);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                System.out.print(bp[i][j].getDescription() + " ");
            }
            System.out.print("\n");
        }
    }
}
