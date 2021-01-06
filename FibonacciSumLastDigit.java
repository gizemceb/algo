import java.util.Scanner;

public class FibonacciSumLastDigit {
    static long FibonacciSumLastDigit(long n){

        long sum = 1;
        if(n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for(long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10 ;
            sum = (sum + current ) % 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        System.out.println(FibonacciSumLastDigit(n));
    }
}
