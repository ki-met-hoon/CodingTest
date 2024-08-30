import java.io.*;
import java.util.*;

class Main {
    private static int total = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = bufferedReader.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int temp = 1;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                stack.addLast(c);
                temp *= 2;
            }
            if (c == '[') {
                stack.addLast(c);
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peekLast()!= '(') {
                    checkError(bufferedWriter);
                    return;
                }

                if (line.charAt(i - 1) == '(') {
                    total += temp;
                }

                temp /= 2;
                stack.removeLast();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peekLast() != '[') {
                    checkError(bufferedWriter);
                    return;
                }

                if (line.charAt(i - 1) == '[') {
                    total += temp;
                }

                temp /= 3;
                stack.removeLast();
            }
        }

        if (!stack.isEmpty()) {
            checkError(bufferedWriter);
            return;
        }

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.flush();
    }

    private static void checkError(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(String.valueOf(0));
        bufferedWriter.flush();
    }
}
