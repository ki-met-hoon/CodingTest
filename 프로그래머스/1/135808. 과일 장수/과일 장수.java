import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int ans = 0;
        int index = score.length - 1;
        
        while(index >= m - 1) {
            index -= m;
            ans += score[index + 1] * m;
        }
        
        return ans;
    }
}