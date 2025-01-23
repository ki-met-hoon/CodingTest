import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        
        int[] student = new int[n + 2];
        Arrays.fill(student, 1);
        
        for(int i = 0; i < lost.length; i++) {
            student[lost[i]]--;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            student[reserve[i]]++;
        }
        
        for(int i = 1; i < student.length - 1; i++) {
            if(student[i] == 2) {
                if(student[i - 1] == 0) {
                    student[i - 1]++;
                    continue;
                }
            
                if(student[i + 1] == 0) {
                    student[i + 1]++;
                    continue;
                }
            }
        }
        
        for(int i = 1; i < student.length - 1; i++) {
            if(student[i] >= 1) {
                count++;
            }
        }
        
        return count;
    }
}