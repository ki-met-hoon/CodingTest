import java.util.*;
import java.io.*;

class Main {

    private static int[][] map;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
        int[][] directionMap;
        Tail tail;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        map[0][0] = 2;
        directionMap = new int[n][n];

        for(int i = 0; i < k; i++) {
            int[] apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x = apple[0] - 1;
            int y = apple[1] - 1;

            map[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        HashMap<Integer, String> direction = new HashMap<>();

        for(int i = 0; i < l; i++) {
            String[] directionInfo = br.readLine().split(" ");
            direction.put(Integer.parseInt(directionInfo[0]), directionInfo[1]);
        }

        boolean flag = true;

        int headDirection = 0;
        int headX = 0;
        int headY = 0;

        tail = new Tail(0, 0, 0);

        int time = 0;

        while(flag) {
            headDirection = getHeadDirection(direction, headDirection, time);
            directionMap[headX][headY] = headDirection;

            int nx = headX + dx[headDirection];
            int ny = headY + dy[headDirection];

            if(isEnd(nx, ny)) {
                flag = false;
                continue;
            }

            if(!checkApple(nx, ny)) {
                removeTail(tail);

                int tempX = tail.x;
                int tempY = tail.y;

                tail.x += dx[directionMap[tempX][tempY]];
                tail.y += dy[directionMap[tempX][tempY]];
            }

            move(nx, ny);
            time++;

            headX = nx;
            headY = ny;
        }

        bw.write(String.valueOf(time + 1));
        bw.flush();
    }

    private static int getHeadDirection(HashMap<Integer, String> direction, int headDirection, int time) {
        if(direction.containsKey(time)) {
            String position = direction.get(time);

            if(position.equals("D")) {
                headDirection = (headDirection + 1) % 4;
            } else if(position.equals("L")) {
                headDirection = (headDirection + 3) % 4;
            }
        }
        return headDirection;
    }

    private static void move(int x, int y) {
        map[x][y] = 2;
    }

    private static boolean isEnd(int x, int y) {
        return !(0 <= x && x < map.length && 0 <= y && y < map[0].length) || map[x][y] == 2;
    }

    private static boolean checkApple(int x, int y) {
        return map[x][y] == 1;
    }

    private static void removeTail(Tail tail) {
        map[tail.x][tail.y] = 0;
    }

    private static class Tail {
        int x;
        int y;
        int direction;

        public Tail(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
