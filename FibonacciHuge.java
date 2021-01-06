import java.util.Scanner;
public class FibonacciHuge {
    static long fibonacciNumberAgain(long n, long m) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        System.out.println(fibonacciNumberAgain(n,m));
    }
}
