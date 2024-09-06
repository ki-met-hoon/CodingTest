import java.io.*;

class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        boolean[] visited = new boolean[n];
        int[] ans = new int[m];
        dfs(m, visited, n, 0, ans);
        bw.flush();
    }

    private static void dfs(int m, boolean[] visited, int n, int depth, int[] ans) throws IOException {
        if (depth == m) {
            for (int result : ans) {
                bw.write(String.valueOf(result));
                bw.write(" ");
            }

            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = i + 1;
                dfs(m, visited, n, depth + 1, ans);
                visited[i] = false;
            }
        }
    }
}
