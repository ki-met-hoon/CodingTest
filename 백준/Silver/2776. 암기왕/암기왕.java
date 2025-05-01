import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = Integer.parseInt(br.readLine());
            int[] note2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(note1);

            int start = 0;
            int end = note1.length - 1;

            for (int i = 0; i < M; i++) {
                int index = lowerBound(start, end, note2[i], note1);

                if (checkNum(note1, index, note2[i])) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }

                sb.append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static int lowerBound(int start, int end, int key, int[] nums) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private static boolean checkNum(int[] nums, int num, int key) {
        return nums[num] == key;
    }
}
