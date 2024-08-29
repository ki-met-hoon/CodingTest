import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    private static boolean[] check;
    private static TreeSet<String> ans;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = bufferedReader.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<int[]> bracket = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                stack.addLast(i);
            } else if (c== ')') {
                bracket.add(new int[]{stack.removeLast(), i});
            }
        }

        check = new boolean[line.length()];
        ans = new TreeSet<>();

        dfs(0, line.toCharArray(), bracket);

        Iterator<String> iter = ans.iterator();
        iter.next();
        while (iter.hasNext()) {
            bufferedWriter.write(String.valueOf(iter.next()));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    private static void dfs(int position, char[] line, ArrayList<int[]> bracket) {
        if (position == bracket.size()) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < line.length; i++) {
                if (!check[i]) {
                    stringBuilder.append(line[i]);
                }
            }

            ans.add(String.valueOf(stringBuilder));
            return;
        }

        dfs(position + 1, line, bracket);
        check[bracket.get(position)[0]] = true;
        check[bracket.get(position)[1]] = true;
        dfs(position + 1, line, bracket);
        check[bracket.get(position)[0]] = false;
        check[bracket.get(position)[1]] = false;
    }
}
