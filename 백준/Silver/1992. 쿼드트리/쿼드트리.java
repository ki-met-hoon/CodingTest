import java.util.*;
import java.io.*;

class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] video = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < N; j++) {
                video[i][j] = temp[j];
            }
        }

        divide(video, 0, 0, N);

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static void divide(int[][] video, int startX, int startY, int division) {
        int compareNum = video[startX][startY];
        boolean isSame = true;

        for (int i = startX; i < startX + division; i++) {
            for (int j = startY; j < startY + division; j++) {
                if (video[i][j] != compareNum) {
                    isSame = false;
                    break;
                }
            }

            if (!isSame) {
                break;
            }
        }

        if (!isSame) {
            sb.append("(");

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divide(video, (i * division / 2) + startX, (j * division / 2) + startY, division / 2);
                }
            }

            sb.append(")");
            return;
        }

        sb.append(compareNum);
    }
}
