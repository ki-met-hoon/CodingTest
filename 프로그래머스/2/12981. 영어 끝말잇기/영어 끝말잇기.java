import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char last = words[0].charAt(0);
        boolean flag = false;
        
        ArrayList<String>[] people = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            people[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < people.length; j++) {
                for(String k : people[j]) {
                    if (k.equals(words[i])) {
                        answer[0] = (i % n) + 1;
                        answer[1] = people[i % n].size() + 1;
                        flag = true;
                    }
                }
            }
            
            if(flag) {
                break;
            }
            
            if(last != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (people[i % n].size()) + 1;
                break;
            } else {
                people[i % n].add(words[i]);   
                last = words[i].charAt(words[i].length() - 1);
            }
        }
        
        return answer;
    }
}