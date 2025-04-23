import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Answer[] answerList = new Answer[n];

        for(int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            answerList[i] = new Answer(temp[0], temp[1], temp[2]);
        }

        ArrayList<Integer> candidate = new ArrayList<>();

        for(int i = 102; i <988; i++) {
            if(findSameNum(i)) {
                continue;
            }

            candidate.add(i);
        }

        for(int i = 0; i < n; i++) {
            Answer answer = answerList[i];

            ArrayList<Integer> candidates = new ArrayList<>();

            for(int j = 0; j < candidate.size(); j++) {
                int[] count = checkCount(answer.num, candidate.get(j));

                if(Arrays.equals(count, answer.count)) {
                    candidates.add(candidate.get(j));
                }
            }

            candidate = candidates;
        }

        bw.write(String.valueOf(candidate.size()));
        bw.flush();
    }

    private static class Answer {
        int num;
        int[] count;

        public Answer(int num, int strikeCount, int ballCount) {
            this.num = num;
            this.count = new int[]{strikeCount, ballCount};
        }
    }

    private static boolean findSameNum(int num) {
        boolean[] checkNum = new boolean[10];
        int[] numList = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < numList.length; i++) {
            if (numList[i] == 0) {
                return true;
            }

            if(checkNum[numList[i]]) {
                return true;
            }

            checkNum[numList[i]] = true;
        }

        return false;
    }

    private static int[] checkCount(int num, int answer) {
        String[] numStr = String.valueOf(num).split("");
        String[] answerStr = String.valueOf(answer).split("");

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < answerStr.length; i++) {
            if (Arrays.toString(numStr).contains(answerStr[i])) {
                if (numStr[i].equals(answerStr[i])) {
                    strikeCount++;
                    continue;
                }

                ballCount++;
            }
        }

        return new int[]{strikeCount, ballCount};
    }
}
