import java.util.HashMap;
import java.util.Map;

public class RecursionProblems {

    public static long factorial(int n) {
        // TODO: base case n <= 1 -> 1, else n * factorial(n-1)
        return -1;
    }

    public static long fibonacci(int n) {
        // TODO: plain recursive version (yes, it's slow — that's the point, compare to memo version)
        return -1;
    }

    public static long fibonacciMemo(int n) {
        return fibonacciMemo(n, new HashMap<>());
    }

    private static long fibonacciMemo(int n, Map<Integer, Long> cache) {
        // TODO: check cache first, else compute + store
        return -1;
    }

    public static long power(int base, int exp) {
        // TODO: fast exponentiation, O(log n)
        // hint: power(b, e) = if e even: half*half, if odd: base * power(b, e-1)
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
        System.out.println("fib(10) = " + fibonacci(10));
        System.out.println("fibMemo(40) = " + fibonacciMemo(40));
        System.out.println("2^10 = " + power(2, 10));
    }
}
