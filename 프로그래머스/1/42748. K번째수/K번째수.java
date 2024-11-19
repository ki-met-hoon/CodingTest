import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            int count = 0;

            int[] arrInteger = new int[j - i + 1];
            for (int idx = i - 1; idx < j; idx++) {
                arrInteger[count] = array[idx];
                count++;
            }

            Arrays.sort(arrInteger);
            answer[l] = arrInteger[k - 1];
        }

        return answer;
    }
}