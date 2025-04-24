import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nl[0];
        int l = nl[1];

        int[] water = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(water);

        boolean[] pos = new boolean[2002];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int start = (int) ((water[i] - 0.5) * 2);
            int end = (int) ((water[i] + 0.5) * 2);

            if (pos[start] && pos[end]) {
                continue;
            }

            for (int j = start; j <= start + l * 2; j++) {
                if (j > 2001) {
                    break;
                }
                
                pos[j] = true;
            }

            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
