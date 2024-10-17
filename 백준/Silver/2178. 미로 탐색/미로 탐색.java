import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        Deque<Position> queue = new ArrayDeque<>();
        queue.offerFirst(new Position(0, 0, 1));

        while(!queue.isEmpty()) {
            Position cur = queue.pollLast();

            int cx = cur.x;
            int cy = cur.y;
            int val = cur.val;

            if (cx == n - 1 && cy == m - 1) {
                bw.write(String.valueOf(val));
                bw.flush();
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offerFirst(new Position(nx, ny, val + 1));
                    }
                }
            }
        }
    }

    private static class Position {
        int x;
        int y;
        int val;

        public Position(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
