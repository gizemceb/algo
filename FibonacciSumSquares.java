import java.util.Scanner;
import java.util.StringTokenizer;

public class FibonacciSumSquares {
    static long FibonacciSumSquares(long m){
        long sum = 0;
        if(m <= 1)
            return m;
        long previous = 0;
        long next = 1;

        for( long i = 0; i < m-1; ++i) {
            long tmp_previous = previous;
            previous = next;
            next = (tmp_previous + next) % 10;

        }
        return (previous + next) * next % 10;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        System.out.println(FibonacciSumSquares(n));
    }
}
