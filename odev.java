import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class odev {
    static long odev(long[] numbers) {
        int n = numbers.length;
        if(numbers.length == 0)
            return 0;
        if(numbers.length == 1)
            return numbers[0];

        int max1, max2;
        if(numbers[1] > numbers[0]) {
            max1 = 1;
            max2 = 0;
        }else {
            max2 = 1;
            max1 = 0;
        }

        for(int i = 2; i < n; i++) {
            if(numbers[i] > numbers[max1]){
                max2 = max1;
                max1 = i;
            }
            else if(numbers[i] > numbers[max2])
                max2 = i;
        }
        return numbers[max1] * numbers[max2];

    }
    public static void main(String [] args){
        odev.FastScanner scanner = new odev.FastScanner(System.in);

        int n = scanner.nextInt();
        long [] numbers = new long[n];
        for (int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.println(odev(numbers));

    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
