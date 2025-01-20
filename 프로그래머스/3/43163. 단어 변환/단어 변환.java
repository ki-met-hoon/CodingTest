import java.util.*;

class Solution {
    private static boolean flag;
    private static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        int result = 0;
        
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(begin, false);
        for(String word : words) {
            visited.put(word, false);
        }
        
        dfs(begin, target, visited, words, result);
        
        if(flag) {
            return answer; 
        }
        
        return 0;
    }
    
    private void dfs(String begin, String target, HashMap<String, Boolean> visited, String[] words, int result) {
        if(begin.equals(target)) {
            flag = true;
            answer = result;
            return;
        }
        
        for(String word : words) {
            int count = 0;
            
            if(!visited.get(word)) {
                for(int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) != begin.charAt(i)) {
                        count++;
                    }
                }
                
                if(count == 1) {
                    visited.replace(begin, true);
                    dfs(word, target, visited, words, result + 1);
                    visited.replace(word, false);
                }
            }
        }
    }
}