import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                if (temp[j].equals("1")) {
                    map[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];

            dfs(visited, map, i);

            for (int j = 0; j < n; j++) {
                sb.append(visited[j]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void dfs(int[] visited, ArrayList<Integer>[] map, int idx) {
        for (int i = 0; i < map[idx].size(); i++) {
            int cn = map[idx].get(i);

            if (visited[cn] == 0) {
                visited[cn] = 1;
                dfs(visited, map, cn);
            }
        }
    }
}
