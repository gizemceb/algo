import java.util.Scanner;

public class FibonacciPartialSum {
    static long FibonacciPartialSum(long n, long m){
        long sum = 0;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i <= m; ++i) {
            if (i >= n) {
                sum += previous;
            }
            long new_current = current;
            current = current + previous;
            previous = new_current;
        }
        return sum % 10;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(FibonacciPartialSum(n, m));
    }
}
