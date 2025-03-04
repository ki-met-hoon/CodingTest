import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if(list.isEmpty()) {
            list.add(-1);
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}