import java.util.*;

class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        LinkedList<Integer>[] network = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            network[i] = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    network[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(network, visited, i);
            }
        }

        return answer;
    }

    private static void dfs(LinkedList<Integer>[] network, boolean[] visited, int idx) {
        visited[idx] = true;

        for (int i = 0; i < network[idx].size(); i++) {
            if (!visited[network[idx].get(i)]) {
                dfs(network, visited, network[idx].get(i));
            }
        }
    }
}