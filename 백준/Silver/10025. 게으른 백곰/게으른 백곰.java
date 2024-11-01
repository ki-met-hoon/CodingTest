import java.util.*;
import java.io.*;

public class Main {

    private static final int RANGE = 1000001;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] map = new int[RANGE];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] gk = br.readLine().split(" ");

            int g = Integer.parseInt(gk[0]);
            int x = Integer.parseInt(gk[1]);
            map[x] = g;

            if (x < min) {
                min = x;
            }

            if (x > max) {
                max = x;
            }
        }

        int left = min;
        int right = min + 2 * k + 1;

        int val = 0;

        for (int i = left; i < right; i++) {
            if (i >= RANGE) break;
            val += map[i];
        }

        int ans = val;

        for (int i = left + 1; i <= max - 2 * k; i++) {
            int temp = val;

            if (map[i - 1] != 0) {
                temp -= map[i - 1];
            }

            if (map[right] != 0) {
                temp += map[right];
            }

            if (ans < temp) {
                ans = temp;
            }

            val = temp;
            right++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
