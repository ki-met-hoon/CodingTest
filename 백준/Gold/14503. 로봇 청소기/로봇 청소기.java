import java.io.*;
import java.util.*;

class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {-0, 1, 0, -1};
    private static final int[] cleanerPosition = new int[2];
    private static int[][] map;
    private static int look;
    private static int ans;
    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[rc[0]][rc[1]];

        int[] rcd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cleanerPosition[0] = rcd[0];
        cleanerPosition[1] = rcd[1];
        look = rcd[2];

        for (int i = 0; i < rc[0]; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < rc[1]; j++) {
                map[i][j] = temp[j];
            }
        }

        while (flag) {
            clean();

            if (allClean()) {
                moveBack();
            } else {
                move();
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void moveBack() {
        int nx = cleanerPosition[0] + dx[(look + 2) % 4];
        int ny = cleanerPosition[1] + dy[(look + 2) % 4];

        if (checkBack(nx, ny)) {
            cleanerPosition[0] = nx;
            cleanerPosition[1] = ny;
        } else {
            flag = false;
        }
    }

    private static boolean checkBack(int nx, int ny) {
        return 0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && map[nx][ny] != 1;
    }

    private static boolean allClean() {
        int cx = cleanerPosition[0];
        int cy = cleanerPosition[1];

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {
                if (check(nx, ny)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void move() {
        while(true) {
            rotation();

            int nx = cleanerPosition[0] + dx[look];
            int ny = cleanerPosition[1] + dy[look];

            if (checkForward(nx, ny)) {
                cleanerPosition[0] = nx;
                cleanerPosition[1] = ny;
                return;
            }
        }
    }

    private static void rotation() {
        look = (look - 1 + 4) % 4;
    }

    private static boolean checkForward(int nx, int ny) {
        if (!(0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length)) {
            return false;
        }

        return map[nx][ny] == 0;
    }

    private static void clean() {
        int cx = cleanerPosition[0];
        int cy = cleanerPosition[1];

        if (check(cx, cy)) {
            map[cx][cy] = 2;
            ans++;
        }
    }

    private static boolean check(int x, int y) {
        return map[x][y] == 0;
    }
}
