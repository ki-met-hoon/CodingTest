import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
            
        int ans = 0;
        
        for(int key : list) {
            if(k <= 0) {
                break;
            }
            
            k -= map.get(key);
            ans++;
        }
    
        return ans;
    }
}