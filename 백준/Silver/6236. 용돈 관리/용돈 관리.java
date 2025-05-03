import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        int[] moneyArr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            max = Math.max(max, money);

            moneyArr[i] = money;
        }

        int start = max;
        int end = Arrays.stream(moneyArr).sum();

        bw.write(String.valueOf(lowerBound(start, end, moneyArr, M)));
        bw.flush();
    }

    private static int lowerBound(int start, int end, int[] moneyArr, int M) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (checkCount(mid, moneyArr) > M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private static int checkCount(int money, int[] moneyArr) {
        int k = 1;
        int saveMoney = money;

        for (int i = 0; i < moneyArr.length; i++) {
            int useMoney = moneyArr[i];

            if (useMoney > saveMoney) {
                k++;
                saveMoney = money;
            }

            saveMoney -= useMoney;
        }

        return k;
    }
}
