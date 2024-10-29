import java.io.*;
import java.util.*;

class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean isConsistency = true;
            Trie root = new Trie();

            for (int i = 0; i < n; i++) {
                if (!checkConsistency(br.readLine(), root)) {
                    isConsistency = false;
                }
            }

            if (!isConsistency) {
                sb.append("NO").append("\n");
                continue;
            }

            sb.append("YES").append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    private static boolean checkConsistency(String word, Trie curNode) {
        for (char ch : word.toCharArray()) {
            if (curNode.endOfWord) {
                return false;
            }

            if (!curNode.children.containsKey(ch)) {
                curNode.children.put(ch, new Trie());
            }

            curNode = curNode.children.get(ch);
        }


        if (!curNode.children.isEmpty()) {
            return false;
        }

        curNode.endOfWord = true;
        return true;
    }

    private static class Trie {
        HashMap<Character, Trie> children;
        boolean endOfWord;

        public Trie() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }
}
