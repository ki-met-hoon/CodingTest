import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            if(citations.length - i <= citations[i]) {
                ans = citations.length - i;
                break;
            }
        }
        
        //0, 1, 3, 5, 6
        
        return ans;
    }
}