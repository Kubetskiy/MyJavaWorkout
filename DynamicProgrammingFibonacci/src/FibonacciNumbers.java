/**
 * Числа Фибоначи - элементы числовой последовательности в которой
 * первые два числа равны 0 и 1, а каждое последующее число равно
 * сумме двух предыдущих чисел.
 */
public class FibonacciNumbers {
    private static final int QUANTITY_NUMBERS = 20;

    public static void main(String[] args) {
// TODO Считает только до 94-го числа - дальше нужно BigInteger
        for (int i = 1; i <= 93; i++) {
//            System.out.printf("\nРекурсивная функция fibRecursion(): %d\n", fibRecursion(i));
            System.out.printf("№ Числа: %d\n", i);
            System.out.printf("Через массив fibWithArray(): %d\n", fibWithArray(i));
            System.out.printf("fibN(): %d\n", fibN(i));
        }
    }

    /**
     * Вычисление number-го числа Фибоначи через рекурсивные вызовы
     * На моем конкретном компе комфортный предел 45
     */
    public static long fibRecursion(int number) {
        return switch (number) {
            case 1 -> 0;
            case 2 -> 1;
            default -> fibRecursion(number - 1) + fibRecursion(number - 2);
        };
    }

    /**
     * Вычисление number-го числа Фибоначи через слздание временного массива
     */
    public static long fibWithArray(int number) {
        long[] numbersFibonacci = new long[number];
        switch (number) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                numbersFibonacci[0] = 0;
                numbersFibonacci[1] = 1;
                for (int i = 2; i < number; i++) {
                    numbersFibonacci[i] = numbersFibonacci[i - 1] + numbersFibonacci[i - 2];
                }
                return numbersFibonacci[number - 1];
        }
    }

    /**
     * Вычисление number-го числа Фибоначи - простой алгоритм
     * @param n from 1
     * @return Fibonacci(n)
     */
    public static long fibN(int n) {
        long x = 1; // F2
        long y = 0; // F1
        for (long i = 1; i < n; i++) {
            x += y;
            y = x - y;
        }
        return y;
    }
}
