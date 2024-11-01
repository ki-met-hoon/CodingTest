import java.util.*;
import java.io.*;

public class Main {

    private static final int INF = 200000000;;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NE = br.readLine().split(" ");
        int N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] temp = br.readLine().split(" ");

            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        String[] position = br.readLine().split(" ");
        int oneNode = Integer.parseInt(position[0]);
        int twoNode = Integer.parseInt(position[1]);

        int v1 = 0;
        v1 += dijkstra(graph, 1, oneNode, N);
        v1 += dijkstra(graph, oneNode, twoNode, N);
        v1 += dijkstra(graph, twoNode, N, N);

        int v2 = 0;
        v2 += dijkstra(graph, 1, twoNode, N);
        v2 += dijkstra(graph, twoNode, oneNode, N);
        v2 += dijkstra(graph, oneNode, N, N);

        if (v1 >= INF && v2 >= INF) {
            bw.write("-1");
            bw.flush();
            return;
        }

        bw.write(String.valueOf(Math.min(v1, v2)));
        bw.flush();
    }

    private static int dijkstra(ArrayList<Node>[] graph, int start, int end, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if (curNode.idx == end) {
                return dist[end];
            }

            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (int i = 0; i < graph[curNode.idx].size(); i++) {
                Node nxtNode = graph[curNode.idx].get(i);

                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        return dist[end];
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
