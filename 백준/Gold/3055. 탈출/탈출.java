import java.util.*;
import java.io.*;

class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] map = new String[rc[0]][rc[1]];

        Pos start = null;

        Deque<Pos> q = new ArrayDeque<>();
        Deque<Pos> water = new ArrayDeque<>();

        boolean[][] visited = new boolean[rc[0]][rc[1]];
        boolean[][] waterVisited = new boolean[rc[0]][rc[1]];

        for (int i = 0; i < map.length; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = temp[j];

                if (temp[j].equals("S")) {
                    start = new Pos(i, j, 0);
                    visited[i][j] = true;
                    continue;
                }

                if (temp[j].equals("X")) {
                    map[i][j] = "X";
                }

                if (temp[j].equals("D")) {
                    map[i][j] = "D";
                }

                if (temp[j].equals("*")) {
                    map[i][j] = "*";
                    water.addFirst(new Pos(i, j, 0));
                }
            }
        }

        q.addFirst(start);

        int answer = 0;

        while (!q.isEmpty()) {
            Pos pos = q.removeLast();

            if (map[pos.x][pos.y].equals("D")) {
                answer = pos.count;
                break;
            }

            while (!water.isEmpty() && water.peekLast().count == pos.count) {
                Pos waterPos = water.removeLast();

                for (int i = 0; i < 4; i++) {
                    int nx = waterPos.x + dx[i];
                    int ny = waterPos.y + dy[i];

                    if (check(nx, ny, map) && !waterVisited[nx][ny] && !map[nx][ny].equals("D") && !map[nx][ny].equals("X")) {
                            map[nx][ny] = "*";
                            waterVisited[nx][ny] = true;
                            water.addFirst(new Pos(nx, ny, waterPos.count + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];


                if (check(nx, ny, map) && !visited[nx][ny] && !map[nx][ny].equals("*") && !map[nx][ny].equals("X")) {
                    visited[nx][ny] = true;
                    q.addFirst(new Pos(nx, ny, pos.count + 1));
                }
            }
        }

        if (answer == 0) {
            bw.write("KAKTUS");
            bw.flush();
            return;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static boolean check(int x, int y, String[][] map) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }

    private static class Pos {
        int x;
        int y;
        int count;

        public Pos(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
