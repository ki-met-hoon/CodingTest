import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[temp[0]].add(new Node(temp[1], temp[2]));
            graph[temp[1]].add(new Node(temp[0], temp[2]));
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < graph.length; i++) {
            visited[i] = true;
            dfs(graph, i, 0, visited);
            visited[i] = false;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void dfs(ArrayList<Node>[] graph, int curIdx, int curCost, boolean[] visited) {
        for (int i = 0; i < graph[curIdx].size(); i++) {
            int nxtIdx = graph[curIdx].get(i).idx;
            int nxtCost = graph[curIdx].get(i).cost;

            if (!visited[nxtIdx]) {
                visited[nxtIdx] = true;
                dfs(graph, nxtIdx, curCost + nxtCost, visited);
                visited[nxtIdx] = false;
            }
        }

        result = Math.max(result, curCost);
    }

    private static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
