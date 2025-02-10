import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int check = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for(int[] i : routes) {
            if(i[0] <= check && check <= i[1]) {
                continue;
            }
            
            check = i[1];
            ans++;
        }
        
        return ans;
    }
}