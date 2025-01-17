import java.util.*;

class Solution {
    private static int count;
    
    public int solution(int n, int[][] wires) {
        int result = n;
        
        LinkedList<Integer>[] linkedList = new LinkedList[n + 1];
        for(int i = 0; i <= n; i++) {
            linkedList[i] = new LinkedList<>();
        }
        
        for(int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            linkedList[start].add(end);
            linkedList[end].add(start);
        }
        
        for(int[] wire : wires) {
            count = 0;
            boolean[] visited = new boolean[n + 1];
            
            dfs(linkedList, 1, visited, wire);
            
            result = Math.min(Math.abs((n - count) - count), result);
        }
        
        return result;
    }
    
    private void dfs(LinkedList<Integer>[] linkedList, int idx, boolean[] visited, int[] wire) {
        count++;
        visited[idx] = true;
        
        for(int i : linkedList[idx]) {
            if(((idx == wire[0] && i == wire[1]) || (idx == wire[1] && i == wire[0])) || visited[i]) {
                    continue;
                }
                
                dfs(linkedList, i, visited, wire);
        }
    }
}