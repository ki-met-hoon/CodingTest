import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] code = br.readLine().toCharArray();
        long[] dp = new long[code.length + 1];

        if (code[0] == '0') {
            bw.write("0");
            bw.flush();
            return;
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int val = Integer.parseInt(String.valueOf(code[i - 2]) + code[i - 1]);

            if (val > 26 && code[i - 1] == '0' || val == 0) {
                bw.write("0");
                bw.flush();
                return;
            }

            if (code[i - 1] == '0') {
                dp[i] = dp[i - 2];
                dp[i] %= 1000000;
                continue;
            }

            if (val <= 26 && code[i - 2] != '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %= 1000000;
                continue;
            }


            dp[i] = dp[i - 1];
            dp[i] %= 1000000;
        }

        bw.write(String.valueOf(dp[code.length]));
        bw.flush();
    }
}
