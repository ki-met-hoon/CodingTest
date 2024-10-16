import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] route = new long[n + 1][n + 1];

        for (long[] line : route) {
            Arrays.fill(line, INF);
        }

        for (int i = 1; i <= n; i++) {
            route[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int val = Integer.parseInt(temp[2]);

            route[start][end] = Math.min(route[start][end], val);
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    route[i][j] = Math.min(route[i][k] + route[k][j], route[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (route[i][j] == INF) {
                    sb.append(0).append(" ");
                    continue;
                }

                sb.append(route[i][j]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
