import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int result = 0;
        
        int[] count = new int[3];
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % 5]) {
                count[0]++;
            }
            
            if(answers[i] == two[i % 8]) {
                count[1]++;
            }
            
            if(answers[i] == three[i % 10]) {
                count[2]++;
            }
        }
        
        System.out.println(Arrays.toString(count));
        
        for(int i : count) {
            result = Math.max(i, result);
        }
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] == result) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}