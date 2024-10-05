import java.io.*;
import java.util.*;

class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];
        int max = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(temp[j]);

                if (area[i][j] > max) {
                    max = area[i][j];
                }
            }
        }

        int answer = - 1;

        for (int i = 0; i <= max; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (area[j][k] <= i || visited[j][k]) {
                        continue;
                    }

                    visited[j][k] = true;
                    dfs(area, visited, j, k, n, i);
                    count++;
                }
            }

            if (count > answer) {
                answer = count;
            }

            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void dfs(int[][] area, boolean[][] visited, int cx, int cy, int n, int idx) {
        for (int l = 0; l < 4; l++) {
            int nx = cx + dx[l];
            int ny = cy + dy[l];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (!visited[nx][ny] && area[nx][ny] > idx) {
                    visited[nx][ny] = true;
                    dfs(area, visited, nx, ny, n, idx);
                }
            }
        }
    }
}
