import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> q = new ArrayDeque<>();
        HashMap<Integer, Integer> process = new HashMap<>();
        int max = 0;
        int count = 0;
        
        for(int i = 0; i < priorities.length; i++) {
            max = Math.max(max, priorities[i]);
            
            process.put(i, priorities[i]);
            q.addFirst(i);
        }
        
        while(!q.isEmpty()) {
            int value = q.removeLast();
            
            if(process.get(value) >= max) {
                if(value == location) {
                    return count + 1;
                }
                
                count++;
                max = 0;
                
                for(int i : q) {
                    max = Math.max(max, priorities[i]);
                }
                
                continue;
            }
            
            q.addFirst(value);
        }
        
        return count;
    }
}