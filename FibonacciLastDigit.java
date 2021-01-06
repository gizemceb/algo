import java.util.Scanner;
public class FibonacciLastDigit {
    static long fibonacciLastDigit(long n) {
       /* long [] array = new long[(int) n];
        array[0] = 0;
        array[1] = 1;

        for(long i = 2; i < n; i++) {
            array[i] = (array[i-1] + array[i-2])% 10;
        }
        return array[n-1];
*/

        long prev = 0;
        long current = 1;
        for(int i = 0; i < n-1; ++i) {
            long tmp_prev = prev;
            prev = current;
            current = (tmp_prev + current) % 10;
        }
        return current;

    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(fibonacciLastDigit(n));
    }
}
