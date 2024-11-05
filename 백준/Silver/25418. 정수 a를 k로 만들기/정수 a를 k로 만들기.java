import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] AK = br.readLine().split(" ");
        int A = Integer.parseInt(AK[0]);
        int K = Integer.parseInt(AK[1]);

        Deque<Value> q = new ArrayDeque<>();
        q.offerFirst(new Value(A, 0));

        boolean[] visited = new boolean[1000001];

        while (!q.isEmpty()) {
            Value curValue = q.pollLast();
            Value nxtValue1 = new Value(oper1(curValue.num), curValue.count + 1);
            Value nxtValue2 = new Value(oper2(curValue.num), curValue.count + 1);

            if (curValue.num == K) {
                bw.write(String.valueOf(curValue.count));
                bw.flush();
                return;
            }

            if (nxtValue2.num > K) {
                if (visited[nxtValue1.num]) {
                    continue;
                }

                q.offerFirst(nxtValue1);
                visited[nxtValue1.num] = true;
                continue;
            }

            if (visited[nxtValue1.num] && visited[nxtValue2.num]) {
                continue;
            }

            if (visited[nxtValue1.num]) {
                q.offerFirst(nxtValue2);
                visited[nxtValue2.num] = true;
                continue;
            }

            if (visited[nxtValue2.num]) {
                q.offerFirst(nxtValue1);
                visited[nxtValue1.num] = true;
                continue;
            }


            q.offerFirst(nxtValue1);
            visited[nxtValue1.num] = true;
            q.offerFirst(nxtValue2);
            visited[nxtValue2.num] = true;
        }
    }

    private static class Value {
        int num;
        int count;

        public Value(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    private static int oper1(int num) {
        return num + 1;
    }

    private static int oper2(int num) {
        return num * 2;
    }
}
