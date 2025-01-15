class Solution {
    private static int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(k, dungeons, visited, answer);
    }
    
    private int dfs(int k, int[][] dungeons, boolean[] visited, int answer) {
        result = Math.max(result, answer);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, answer + 1);
                visited[i] = false;
            }
        }
        
        return result;
    }
}