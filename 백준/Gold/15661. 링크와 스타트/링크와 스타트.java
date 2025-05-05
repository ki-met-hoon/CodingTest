import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    
    private static int[][] score;
    private static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        score = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            score[i] = temp;
        }

        for (int i = 2; i <= N / 2; i++) {
            boolean[] visited = new boolean[N];
            combination(visited, i, 0, N);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void combination(boolean[] visited, int num, int start, int N) {
        if (num == 0) {
            ArrayList<Integer> oneSubScore = new ArrayList<>();
            ArrayList<Integer> otherSubScore = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    oneSubScore.add(i);
                } else {
                    otherSubScore.add(i);
                }
            }

            answer = Math.min(answer, Math.abs(calculateScore(oneSubScore) - calculateScore(otherSubScore)));
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(visited, num - 1, i + 1, N);
            visited[i] = false;
        }
    }

    private static int calculateScore(ArrayList<Integer> subScore) {
        int sum = 0;

        for (int i = 0; i < subScore.size() - 1; i++) {
            for (int j = i + 1; j < subScore.size(); j++) {
                sum += (score[subScore.get(i)][subScore.get(j)] + score[subScore.get(j)][subScore.get(i)]);
            }
        }

        return sum;
    }
}
