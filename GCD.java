import java.util.Scanner;
public class GCD {
    static long EuclideanGDC(long a, long b) {
        if(a < 0 || b < 0 ) throw new IllegalArgumentException("Only positive numbers!");
        if(b == 0) return a;

        long remainder = a % b;
        return EuclideanGDC(b,remainder);

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(EuclideanGDC(n, m));
    }
}
