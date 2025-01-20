import java.util.*;

class Solution {
    private static boolean flag;
    private static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        int result = 0;
        
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, visited, words, result);
        
        if(flag) {
            return answer; 
        }
        
        return 0;
    }
    
    private void dfs(String begin, String target, boolean[] visited, String[] words, int result) {
        if(begin.equals(target)) {
            flag = true;
            answer = result;
            return;
        }
        
        for(int j = 0; j < words.length; j++) {
            int count = 0;
            
            if(!visited[j]) {
                for(int i = 0; i < words[j].length(); i++) {
                    if(words[j].charAt(i) != begin.charAt(i)) {
                        count++;
                    }
                }
                
                if(count == 1) {
                    visited[j] = true;
                    dfs(words[j], target, visited, words, result + 1);
                    visited[j] = false;
                }
            }
        }
    }
}