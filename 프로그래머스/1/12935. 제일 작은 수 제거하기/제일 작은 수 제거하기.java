import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length < 2) {
            int[] ans = {-1};
            return ans;
        }
        
        int[] copy = arr.clone();
        Arrays.sort(copy);
        int min = copy[0];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) {
                continue;
            }
            
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}