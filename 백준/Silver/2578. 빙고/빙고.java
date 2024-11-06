import java.util.*;
import java.io.*;

public class Main {
    private static int[] row = {0, 1, 2, 3, 4};
    private static int[] col = {0, 1, 2, 3, 4};
    private static int leftCross = 0;
    private static int rightCross = 0;

    private static int count;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[5][5];
        HashMap<Integer, Position> position = new HashMap<>();

        for (int i = 0; i < map.length; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < map[0].length; j++) {
                int num = Integer.parseInt(temp[j]);
                map[i][j] = num;

                position.put(num, new Position(i, j));
            }
        }

        int result = 0;

        for (int i = 0; i < map.length; i++) {
            String[] val = br.readLine().split(" ");

            for (int j = 0; j < map[0].length; j++) {
                result++;
                Position cur = position.get(Integer.parseInt(val[j]));
                map[cur.x][cur.y] = 0;

                checkRow(map);
                checkCol(map);
                checkLeftCross(map);
                checkRightCross(map);

                if (count >= 3) {
                    bw.write(String.valueOf(result));
                    bw.flush();
                    return;
                }

                count = 0;
            }
        }
    }

    //가로 체크
    public static void checkRow(int[][] map) {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 세로 체크
    public static void checkCol(int[][] map) {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(map[j][i] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 왼쪽에서 오른쪽으로 그어지는 대각선 체크
    public static void checkLeftCross(int[][] map) {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(map[i][i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }

    // 오른쪽에서 왼쪽으로 그어지는 대각선 체크
    public static void checkRightCross(int[][] map) {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(map[i][4-i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
