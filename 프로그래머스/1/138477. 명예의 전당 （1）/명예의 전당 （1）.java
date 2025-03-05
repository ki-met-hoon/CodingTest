import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] ans = new int[score.length];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(score[0]);
        ans[0] = score[0];
        
        for(int i = 1; i < score.length; i++) {
            int j;
            for(j = 0; j < list.size(); j++) {
                if(score[i] > list.get(j)) {
                    break;
                }
            }
            
            list.add(j, score[i]);
            
            if(list.size() > k) {
                list.removeLast();
            }
            
            ans[i] = list.getLast();
        }
        
        return ans;
    }
}