import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    private static int ans = Integer.MIN_VALUE;
    private static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        Info[] info = new Info[n + 1];
        int[] mv = new int[n + 2];

        for (int i = 1; i < info.length; i++) {
            String[] temp = br.readLine().split(" ");

            info[i] = new Info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        dp(info, mv);
        bw.write(String.valueOf(mv[1]));
        bw.flush();
    }

    private static void dp(Info[] info, int[] mv) {
        for (int i = n; i > 0; i--) {
            if (i + info[i].date > n + 1) {
                mv[i] = mv[i + 1];
            } else {
                mv[i] = Math.max(mv[i + 1], info[i].val + mv[i + info[i].date]);
            }
        }
    }

    private static class Info {
        int date;
        int val;

        public Info(int date, int val) {
            this.date = date;
            this.val = val;
        }
    }
}
