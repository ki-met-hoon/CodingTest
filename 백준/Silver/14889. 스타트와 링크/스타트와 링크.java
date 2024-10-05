import java.io.*;

class Main {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        comi(visited, map, 1, 0);
        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void comi(boolean[] visited, int[][] map, int idx, int depth) {
        if (depth == (visited.length - 1) / 2) {
            diff(map, visited);
        }

        for (int i = idx; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comi(visited, map, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff(int[][] map, boolean[] visited) {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 1; i < map.length - 1; i++) {
            for (int j = i + 1; j < map.length; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }

        int val = Math.abs(startTeam - linkTeam);

        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}
