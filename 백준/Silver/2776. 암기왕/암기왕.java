import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] note1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < N; i++) {
                map.put(note1[i], 0);
            }

            int M = Integer.parseInt(br.readLine());
            int[] note2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < M; j++) {
                if (map.containsKey(note2[j])) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }

                sb.append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
