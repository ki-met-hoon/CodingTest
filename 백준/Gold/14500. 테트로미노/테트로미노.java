import java.util.*;
import java.io.*;

class Main {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] diaX = {-1, -1, +1, +1};
    private static int[] diaY = {-1, +1, +1, -1};
    private static int[][] map;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[NM[0]][NM[1]];

        for (int i = 0; i < NM[0]; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < NM[1]; j++) {
                map[i][j] = temp[j];
            }
        }

        boolean[][] visited = new boolean[NM[0]][NM[1]];
        for (int i = 0; i < NM[0]; i++) {
            for (int j = 0; j < NM[1]; j++) {
                visited[i][j] = true;
                DFS(1, i, j, map[i][j], visited);
                visited[i][j] = false;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    int nx1 = i + diaX[k % 4];
                    int ny1 = j + diaY[k % 4];

                    int nx2 = i + diaX[(k + 1) % 4];
                    int ny2 = j + diaY[(k + 1) % 4];

                    if (checkRange(nx1, ny1) && checkRange(nx2, ny2) && checkRange(nx, ny)) {
                        int candidateAns = map[nx1][ny1] + map[nx2][ny2] + map[i][j] + map[nx][ny];
                        answer = Math.max(answer, candidateAns);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void DFS(int count, int x, int y, int sum, boolean[][] visited) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkRange(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(count + 1, nx, ny, sum + map[nx][ny], visited);
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
}
