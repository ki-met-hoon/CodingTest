import java.io.*;
import java.util.*;

class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] numArr = new int[n];
        String[] numStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(numStr[i]);
        }
        Arrays.sort(numArr);

        int[] result = new int[m];
        dfs(0, numArr, result);

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void dfs(int depth, int[] numArr, int[] result) {
        if (depth == result.length) {
            for (int i : result) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < numArr.length; i++) {
            result[depth] = numArr[i];
            dfs(depth + 1, numArr, result);
        }
    }
}
