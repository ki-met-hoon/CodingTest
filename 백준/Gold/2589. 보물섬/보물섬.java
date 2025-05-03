import java.util.*;
import java.io.*;

class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] map = new String[NM[0]][NM[1]];

        for (int i = 0; i < NM[0]; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < NM[1]; j++) {
                map[i][j] = temp[j];
            }
        }

        Deque<Position> q = new ArrayDeque<>();

        for (int i = 0; i < NM[0]; i++) {
            for (int j = 0; j < NM[1]; j++) {
                if (map[i][j].equals("L")) {
                    boolean[][] visited = new boolean[NM[0]][NM[1]];
                    q.addFirst(new Position(i, j, 0));
                    visited[i][j] = true;
                    BFS(q, visited, map);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void BFS(Deque<Position> q, boolean[][] visited, String[][] map) {
        while (!q.isEmpty()) {
            Position pos = q.removeLast();

            answer = Math.max(answer, pos.count);

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;

                if (checkRange(nx, ny, map) && !visited[nx][ny] && !map[nx][ny].equals("W")) {
                    visited[nx][ny] = true;
                    q.addFirst(new Position(nx, ny, pos.count + 1));
                }
            }
        }
    }

    private static class Position {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static boolean checkRange(int x, int y, String[][] map) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
}
