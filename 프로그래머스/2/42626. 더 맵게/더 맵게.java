import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (long i : scoville) {
            priorityQueue.add(i);
        }

        while (priorityQueue.size() != 1 && priorityQueue.peek() < K) {
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();

            answer++;
            priorityQueue.add(first + (second * 2));
        }

        if (priorityQueue.size() == 1 && priorityQueue.peek() < K) {
            return -1;
        }

        return answer;
    }
}