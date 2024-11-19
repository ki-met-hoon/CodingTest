import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();

        for (int i : arr) {
            if (q.isEmpty()) {
                q.addFirst(i);
                continue;
            }

            if (q.peekFirst() == i) {
                continue;
            }

            q.addFirst(i);
        }

        int size = q.size();
        
        int[] answer = new int[q.size()];
        for (int i = 0; i < size; i++) {
            answer[i] = q.pollLast();
        }

        return answer;
    }
}