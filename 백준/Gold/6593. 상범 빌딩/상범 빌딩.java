import java.util.*;
import java.io.*;

public class Main {

    private static final int[] dx = {0, 0, 1, -1, 0, 0};
    private static final int[] dy = {0, 0, 0, 0, 1, -1};
    private static final int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] LRC = br.readLine().split(" ");

            int L = Integer.parseInt(LRC[0]);
            int R = Integer.parseInt(LRC[1]);
            int C = Integer.parseInt(LRC[2]);

            if (L == 0) break;

            String[][][] building = new String[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            Deque<Node> q = new ArrayDeque<>();

            int curL = 0;
            int curR = 0;
            int ans = 0;

            for (int i = 0; i < L * R + L; i++) {
                String[] temp = br.readLine().split("");

                if (temp[0].isEmpty()) {
                    curR = 0;
                    curL++;
                    continue;
                }

                for (int j = 0; j < temp.length; j++) {
                    if (temp[j].equals("S")) {
                        q.offerFirst(new Node(curL, curR, j, 0));
                        visited[curL][curR][j] = true;
                    }

                    building[curL][curR][j] = temp[j];
                }

                curR++;
            }

            while(!q.isEmpty()) {
                Node curNode = q.pollLast();

                if (building[curNode.z][curNode.y][curNode.x].equals("E")) {
                    ans = curNode.time;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = curNode.x + dx[i];
                    int ny = curNode.y + dy[i];
                    int nz = curNode.z + dz[i];

                    if (0 <= nx && nx < C && 0 <= ny && ny < R && 0 <= nz && nz < L){
                        if (!visited[nz][ny][nx] && !building[nz][ny][nx].equals("#")) {
                            visited[nz][ny][nx] = true;
                            q.offerFirst(new Node(nz, ny, nx, curNode.time + 1));
                        }
                    }
                }
            }

            if (ans != 0) {
                System.out.println("Escaped in " + ans +  " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int z;
        int time;

        public Node(int z, int y, int x, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
}
