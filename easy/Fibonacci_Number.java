package easy;

/**
 * 509. Fibonacci Number
 */

public class Fibonacci_Number {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = a + b;
            b = a;
            a = temp;
        }
        return temp;
    }
}
