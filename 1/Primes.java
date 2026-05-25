public class Primes {
    public static void main(String[] args) {
        for (int n = 2; n <= 10000; n++)
            if (isPrime(n))
                System.out.println(n);
    }
    public static boolean isPrime(int n) {
        if (n<=1)
            return false;
        if (n <=3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i*i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
