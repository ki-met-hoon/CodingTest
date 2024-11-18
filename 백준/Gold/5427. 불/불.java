import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static String[][] building;
    private static boolean[][] visited;
    private static int ans;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String[] wh = br.readLine().split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);

            building = new String[h][w];
            visited = new boolean[h][w];
            ans = 0;

            Position start = null;
            Deque<Position> fire = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String[] temp = br.readLine().split("");

                for (int j = 0; j < w; j++) {
                    if (temp[j].equals("@")) {
                        start = new Position(i, j, 0);
                    }

                    if (temp[j].equals("*")) {
                        fire.addFirst(new Position(i, j));
                    }

                    building[i][j] = temp[j];
                }
            }

            bfs(start, fire);

            if (ans == 0) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }

            sb.append(ans).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void bfs(Position start, Deque<Position> fire) {
        Deque<Position> q = new ArrayDeque<>();
        q.addFirst(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Position cur = q.pollLast();

                if (building[cur.x][cur.y].equals("*")) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!(0 <= nx && nx < building.length && 0 <= ny && ny < building[0].length)) {
                        ans += cur.time + 1;
                        return;
                    }

                    if (!visited[nx][ny] && building[nx][ny].equals(".")) {
                        visited[nx][ny] = true;
                        building[nx][ny] = "@";
                        q.addFirst(new Position(nx, ny, cur.time + 1));
                    }
                }
            }

            size = fire.size();
            moveFire(fire, size);
        }
    }

    private static void moveFire(Deque<Position> fire, int size) {
        for (int i = 0; i < size; i++) {
            Position eachFire = fire.pollLast();

            for (int j = 0; j < 4; j++) {
                int nxtFireX = eachFire.x + dx[j];
                int nxtFireY = eachFire.y + dy[j];

                if (0 <= nxtFireX && nxtFireX < building.length && 0 <= nxtFireY && nxtFireY < building[0].length) {
                    if (building[nxtFireX][nxtFireY].equals(".") || building[nxtFireX][nxtFireY].equals("@")) {
                        building[nxtFireX][nxtFireY] = "*";
                        fire.addFirst(new Position(nxtFireX, nxtFireY, eachFire.time + 1));
                    }
                }
            }
        }
    }

    private static class Position {
        int x;
        int y;
        int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
