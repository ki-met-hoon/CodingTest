import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ansArray = new ArrayList<>();
        int[] endDay = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            int remainValue = 100 - progresses[i];
            
            if (remainValue % speeds[i] != 0) {
                endDay[i] = remainValue / speeds[i] + 1;
                continue;
            }
            
            endDay[i] = remainValue / speeds[i];
        }
        
        int start = endDay[0];
        int count = 1;
        
        for(int i = 1; i < endDay.length; i++) {
            if(start < endDay[i]) {
                start = endDay[i];
                ansArray.add(count);
                count = 1;
                continue;
            }
            
            count++;
        }
        
        ansArray.add(count);
        
        return ansArray.stream().mapToInt(i -> i).toArray();
    }
}