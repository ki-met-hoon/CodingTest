import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lineOne = br.readLine().split("");
        String[] lineTwo = br.readLine().split("");

        int[][] map = new int[lineOne.length + 1][lineTwo.length + 1];

        for (int[] ints : map) {
            Arrays.fill(ints, 0);
        }

        bw.write(String.valueOf(dp(map, lineOne, lineTwo)));
        bw.flush();
    }

    private static int dp(int[][] map, String[] one, String[] two) {
        for (int i = 1; i <= one.length; i++) {
            for (int j = 1; j <= two.length; j++) {
                if (one[i - 1].equals(two[j - 1])) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    continue;
                }

                map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
            }
        }

        return map[one.length][two.length];
    }
}