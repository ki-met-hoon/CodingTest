import java.util.*;
import java.io.*;

public class Main {

    private static int[] lesson;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] lessonStr = br.readLine().split(" ");
        lesson = new int[n];
        int sum = 0;
        int minLength = 0;

        for (int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(lessonStr[i]);
            sum += lesson[i];

            if (minLength < lesson[i]) {
                minLength = lesson[i];
            }
        }

        bw.write(String.valueOf(lowerBound(minLength, sum, m)));
        bw.flush();
    }

    private static int lowerBound(int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            int val = getCount(mid);

            if (val > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private static int getCount(int mid) {
        int count = 1;
        int remain = mid;

        for (int i = 0 ; i < lesson.length; i++) {
            if (mid < lesson[i]) {
                count++;
                mid = remain;
            }

            mid -= lesson[i];
        }

        return count;
    }
}