import java.io.*;
import java.util.*;

class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);

        int[][] miro = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[] brokenCount = new int[n * m];
        Arrays.fill(brokenCount, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(0, 0, 0));
        brokenCount[0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (brokenCount[m * cur.x + cur.y] < cur.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (brokenCount[m * nx + ny] > cur.cost + miro[nx][ny]) {
                        brokenCount[m * nx + ny] = cur.cost + miro[nx][ny];
                        queue.offer(new Node(nx, ny, brokenCount[m * nx + ny]));
                    }
                }
            }
        }

        bw.write(String.valueOf(brokenCount[n * m - 1]));
        bw.flush();
    }

    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}