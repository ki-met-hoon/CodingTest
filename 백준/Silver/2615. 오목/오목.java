import java.util.*;
import java.io.*;

class Main {

    private static final int[] dx = {-1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1};
    private static int[][] map;
    private static int leftX = 19;
    private static int leftY = 19;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < 19; j++) {
                map[i][j] = temp[j];
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int num = map[i][j];

                for (int k = 0; k < 4; k++) {
                    int oneLine = countSameNum(num, i + dx[k], j + dy[k], k, 1);
                    int otherLine = countSameNumToOpposite(num, i - dx[k], j - dy[k], k, 1);

                    if ((oneLine + otherLine - 1) == 5) {
                        findMin(i, j);
                        ans = map[leftX][leftY];
                    }
                }
            }
        }

        if (ans == 0) {
            sb.append(ans);
        } else {
            sb.append(ans).append("\n").append(leftX + 1).append(" ").append(leftY + 1);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static int countSameNum(int num, int x, int y, int k, int count) {
        if (!(0 <= x && x < 19 && 0 <= y && y < 19) || map[x][y] != num) {
            return count;
        }

        return countSameNum(num, x + dx[k], y + dy[k], k, count + 1);
    }

    private static int countSameNumToOpposite(int num, int x, int y, int k, int count) {
        if (!(0 <= x && x < 19 && 0 <= y && y < 19) || map[x][y] != num) {
            return count;
        }

        return countSameNumToOpposite(num, x - dx[k], y - dy[k], k, count + 1);
    }

    private static void findMin(int i, int j) {
        if (leftY > j) {
            leftX = i;
            leftY = j;
        } else if (leftY == j) {
            leftX = Math.min(leftX, i);
        }
    }
}
