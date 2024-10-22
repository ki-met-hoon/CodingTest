import java.io.*;
import java.util.*;

class Main {

    private static final String[] operator = {"+", "-", "*", "/"};
    private static int[] arrA;
    private static int max;
    private static int min;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arrA = new int[N];
        String[] arrOper = new String[N - 1];
        String[] temp = br.readLine().split(" ");
        String[] strOperator = br.readLine().split(" ");
        int pointer = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < 4; i++) {
            int val = Integer.parseInt(strOperator[i]);
            saveOperator(i, arrOper, pointer, val);
            pointer += val;
        }

        boolean[] visited = new boolean[N - 1];

        dfs(0, visited, arrOper, arrA[0]);

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void saveOperator(int idx, String[] arrOper, int pointer, int val) {
        for (int i = pointer; i < val + pointer; i++) {
            arrOper[i] = operator[idx];
        }
    }

    private static void dfs(int depth, boolean[] visited, String[] arrOper, int result) {
        String prev = "";

        if (depth == arrOper.length) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }


        for (int i = 0; i < arrOper.length; i++) {
            if (!visited[i] && !arrOper[i].equals(prev)) {
                visited[i] = true;
                prev = arrOper[i];
                int nextResult = calculate(arrOper[i], result, arrA[depth + 1]);
                dfs(depth + 1, visited, arrOper, nextResult);
                visited[i] = false;
            }
        }
    }

    private static int calculate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
