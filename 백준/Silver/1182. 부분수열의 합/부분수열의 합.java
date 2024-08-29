import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    private static int[] nums;
    private static int ans;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NS = bufferedReader.readLine().split(" ");
        String[] numStr = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        
        back(0, S, 0);

        if (S == 0) ans--;
        
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.flush();
    }

    private static void back(int position, int S, int count) {
        if (position == nums.length) {
            if (count == S) {
                ans++;
            }
            
            return;
        }

        back(position + 1, S, count);
        back(position + 1, S, count + nums[position]);
    }
}
