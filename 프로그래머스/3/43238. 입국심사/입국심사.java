import java.util.*;

class Solution {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left < right) {
            long mid = (left + right) / 2;

            if (complete(times, mid) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static long complete(int[] times, long mid) {
        long passCount = 0;

        for (int i : times) {
            passCount += mid / i;
        }

        return passCount;
    }
}