// Подсчет количества простых чисел в интервале 0-N
public class PrimeCheck {
    public static void main(String[] args) {
        int N = 100;

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
// TODO Доразобрать
        for (int i = 2; i*i <= N; i++) { // НОД простого числа не более корня из числа
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes++;
                System.out.println(i);
            }
        }
        System.out.println(
                ">>> The number of primes <= " + N + " is " + primes);
    }
}
