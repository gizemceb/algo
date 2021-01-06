import java.util.Scanner;
public class leastCommonMultiple {
    static long EuclideanGDC(long a, long b) {
        if(a < 0 || b < 0 ) throw new IllegalArgumentException("Only positive numbers!");
        if(b == 0) return a;

        long remainder = a % b;
        return EuclideanGDC(b,remainder);

    }
    static long leastCommonMultiple(long a, long b) {

        long c = EuclideanGDC(a, b);
        return c*(a/c)*(b/c);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(leastCommonMultiple(n, m));
    }
}