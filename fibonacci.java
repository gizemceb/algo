import java.util.Scanner;
public class fibonacci {

   /* static int fibonacci(int n) {
        int [] array = new int[n];
        array[0] = 0;
        array[1] = 1;

        for(int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }*/

    static long nthFibonacci(long n){
        long prev = 0;
        if(n <= 1)
            return n;
        long current = 1;
        for (long i = 0; i < n-1; ++i) {
            long tmp_prev = prev;
            prev = current;
            current = current + tmp_prev;
        }
        return current;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(nthFibonacci(n));
    }
}
