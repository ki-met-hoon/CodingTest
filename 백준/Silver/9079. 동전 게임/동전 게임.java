import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int idx = 0;
        int[] ans = new int[t];
        Arrays.fill(ans, -1);

        while (idx < t) {
            boolean[][][] visited = new boolean[8][8][8];
            int[] init = new int[4];

            for (int i = 0; i < 3; i++) {
                String[] temp = br.readLine().split(" ");

                for (int j = 0; j < 3; j++) {
                    if (temp[j].equals("H")) {
                        init[i] |= 1 << (2 - j);
                    }
                }
            }

            visited[init[0]][init[1]][init[2]] = true;

            Deque<int[]> queue = new ArrayDeque<>();
            queue.offerFirst(init);

            while (!queue.isEmpty()) {
                int[] data = queue.pollLast();
                int first = data[0];
                int second = data[1];
                int third = data[2];
                int val = data[3];

                if (((first | second | third) == 0) || ((first & second & third) == 7)) {
                    ans[idx] = val;
                    break;
                }

                if (!visited[first ^ 7][second][third]) {
                    queue.offerFirst(new int[]{first ^ 7, second, third, val + 1});
                    visited[first ^ 7][second][third] = true;
                }

                if (!visited[first][second ^ 7][third]) {
                    queue.offerFirst(new int[]{first, second ^ 7, third, val + 1});
                    visited[first][second ^ 7][third] = true;
                }

                if (!visited[first][second][third ^ 7]) {
                    queue.offerFirst(new int[]{first, second, third ^ 7, val + 1});
                    visited[first][second][third ^ 7] = true;
                }

                for (int i = 0; i < 3; i++) {
                    int nextFirst = first ^ (1 << i);
                    int nextSecond = second ^ (1 << i);
                    int nextThird = third ^ (1 << i);

                    if (!visited[nextFirst][nextSecond][nextThird]) {
                        queue.offerFirst(new int[]{nextFirst, nextSecond, nextThird, val + 1});
                        visited[nextFirst][nextSecond][nextThird] = true;
                    }
                }

                if (!visited[first ^ 4][second ^ 2][third ^ 1]) {
                    queue.offerFirst(new int[]{first ^ 4, second ^ 2, third ^ 1, val + 1});
                    visited[first ^ 4][second ^ 2][third ^ 1] = true;
                }

                if (!visited[first ^ 1][second ^ 2][third ^ 4]) {
                    queue.offerFirst(new int[]{first ^ 1, second ^ 2, third ^ 4, val + 1});
                    visited[first ^ 1][second ^ 2][third ^ 4] = true;
                }
            }

            idx++;
        }

        for (int i = 0; i < t; i++) {
            bw.write(String.valueOf(ans[i]));
            bw.newLine();
        }

        bw.flush();
    }
}
