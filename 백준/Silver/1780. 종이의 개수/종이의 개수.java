import java.util.*;
import java.io.*;

class Main {

    private static int zeroCount = 0;
    private static int minusCount = 0;
    private static int plusCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < paper.length; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < paper.length; j++) {
                paper[i][j] = temp[j];
            }
        }

        divide(paper, 0, 0, N);

        sb.append(minusCount).append("\n");
        sb.append(zeroCount).append("\n");
        sb.append(plusCount).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void divide(int[][] paper, int startX, int startY, int division) {
        int compareNum = paper[startX][startY];
        boolean isSame = false;

        for (int i = startX; i < startX + division; i++) {
            for (int j = startY; j < startY + division; j++) {
                if (paper[i][j] != compareNum) {
                    isSame = true;

                    for (int k = startX; k < startX + division; k += division / 3) {
                        for (int l = startY; l < startY + division; l += division / 3) {
                            divide(paper, k, l, division / 3);
                        }
                    }

                    break;
                }
            }

            if (isSame) {
                break;
            }
        }

        if (isSame) {
            return;
        }

        if (compareNum == 0) {
            zeroCount++;
        } else if (compareNum == -1) {
            minusCount++;
        } else {
            plusCount++;
        }
    }
}
