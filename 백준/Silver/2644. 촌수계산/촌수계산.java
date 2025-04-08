import java.util.*;
import java.io.*;

class Main {

    private static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = temp[0];
        int end = temp[1];
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = xy[0];
            int y = xy[1];

            graph[x].add(y);
            graph[y].add(x);
        }

        DFS(graph, start, end, visited, 1);

        if(ans == 0) {
            bw.write(String.valueOf(-1));
            bw.flush();
            return;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void DFS(ArrayList<Integer>[] graph, int start, int end, boolean[] visited, int value) {
        visited[start] = true;

        for(int i = 0; i < graph[start].size(); i++) {
            int num = graph[start].get(i);

            if(num == end) {
                ans = value;
                return;
            }

            if(!visited[num]) {
                DFS(graph, num, end, visited, value + 1);
            }
        }
    }
}
