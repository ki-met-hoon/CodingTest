import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(time);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += time[i];
            sum += count;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
