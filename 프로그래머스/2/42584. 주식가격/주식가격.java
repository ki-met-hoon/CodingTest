import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            while(!q.isEmpty() && prices[i] < prices[q.peekLast()]) {
                int idx = q.removeLast();
                ans[idx] = i - idx;
            }
            
            q.addLast(i);
        }
        
        while(!q.isEmpty()) {
            int idx = q.removeLast();
            ans[idx] = prices.length - idx - 1;
        }
        
        return ans;
    }
}