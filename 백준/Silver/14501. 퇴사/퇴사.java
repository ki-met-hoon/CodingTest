import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    private static int ans = Integer.MIN_VALUE;
    private static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        Info[] info = new Info[n + 1];

        for (int i = 1; i < info.length; i++) {
            String[] temp = br.readLine().split(" ");

            info[i] = new Info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        dfs(info, 1, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void dfs(Info[] info, int idx, int pay) {
        if (idx > n) {
            ans = Math.max(ans, pay);
            return;
        }

        if (idx + info[idx].date <= n + 1) {
            dfs(info, idx + info[idx].date, pay + info[idx].val);
        } else {
            dfs(info, idx + info[idx].date, pay);
        }

        dfs(info, idx + 1, pay);
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
