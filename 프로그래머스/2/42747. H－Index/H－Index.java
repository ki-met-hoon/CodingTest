import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = citations.length;
        Arrays.sort(citations);

        //0, 1, 3, 5, 6
        
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] < hIndex) {
                hIndex--;
                continue;
            }
            
            break;
        }
        
        return hIndex;
    }
}