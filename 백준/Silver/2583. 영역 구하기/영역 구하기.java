import java.util.*;
import java.io.*;

class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static boolean[][] visited;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[mnk[0]][mnk[1]];
        visited = new boolean[mnk[0]][mnk[1]];

        for (int i = 0; i < mnk[2]; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] left = {xy[0], xy[1]};
            int[] right = {xy[2] - 1, xy[3] - 1};

            for (int j = left[0]; j <= right[0]; j++) {
                for (int k = left[1]; k <= right[1]; k++) {
                    map[k][j] = 1;
                }
            }
        }

        int answer = 0;
        ArrayList<Integer> range = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    DFS(i, j, map);
                    answer++;
                    range.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(range);

        sb.append(answer).append("\n");

        for (int i : range) {
            sb.append(i).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void DFS(int x, int y, int[][] map) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkRange(nx, ny, map) && !visited[nx][ny] && map[nx][ny] != 1) {
                DFS(nx, ny, map);
            }
        }
    }

    private static boolean checkRange(int x, int y, int[][] map) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
}
