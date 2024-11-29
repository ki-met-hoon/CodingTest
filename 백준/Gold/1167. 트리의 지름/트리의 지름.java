import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    private static int result = 0;
    private static int longestNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[v + 1];
        ArrayList<Node>[] graph = new ArrayList[v + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = temp[0];

            for (int j = 1; j < temp.length; j += 2) {
                if (temp[j] == -1) break;

                graph[start].add(new Node(temp[j], temp[j + 1]));
            }
        }

        visited[1] = true;
        dfs(graph, visited, 1, 0);
        visited[1] = false;

        visited[longestNode] = true;
        dfs(graph, visited, longestNode, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void dfs(ArrayList<Node>[] graph, boolean[] visited, int idx, int dist) {
        if (graph[idx].size() == 1 && visited[graph[idx].get(0).idx]) {
            if (result < dist) {
                result = dist;
                longestNode = idx;
            }

            return;
        }

        for (int i = 0; i < graph[idx].size(); i++) {
            int nxtIdx = graph[idx].get(i).idx;
            int nxtDist = graph[idx].get(i).dist;

            if (!visited[nxtIdx]) {
                visited[nxtIdx] = true;
                dfs(graph, visited, nxtIdx, dist + nxtDist);
                visited[nxtIdx] = false;
            }
        }
    }

    private static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
