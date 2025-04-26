import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int smallPointer = 0;
        int bigPointer = nums.length - 1;
        int answer = 0;

        while(smallPointer < bigPointer) {
            int sum = nums[smallPointer] + nums[bigPointer];

            if (sum > m) {
                bigPointer--;
                continue;
            }

            if (sum < m) {
                smallPointer++;
                continue;
            }

            answer++;

            smallPointer++;
            bigPointer--;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
