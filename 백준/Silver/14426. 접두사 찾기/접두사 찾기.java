import java.io.*;
import java.util.*;

class Main {

    private static int count = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Trie root = new Trie();

        for (int i = 0; i < n; i++) {
            insert(br.readLine(), root);
        }

        for (int i = 0; i < m; i++) {
            search(br.readLine(), root);
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void insert(String word, Trie root) {
        Trie curNode = root;

        for (char ch : word.toCharArray()) {
            if (!curNode.children.containsKey(ch)) {
                curNode.children.put(ch, new Trie());
                curNode = curNode.children.get(ch);
                continue;
            }

            curNode = curNode.children.get(ch);
        }

        curNode.isEndWord = true;
    }

    private static void search(String word, Trie root) {
        Trie curNode = root;

        for (char ch : word.toCharArray()) {
            if (!curNode.children.containsKey(ch)) {
                return;
            }

            curNode = curNode.children.get(ch);
        }

        count++;
    }

    private static class Trie {
        HashMap<Character, Trie> children;
        boolean isEndWord;

        public Trie() {
            this.children = new HashMap<>();
            this.isEndWord = false;
        }
    }
}
