import java.util.*;

class Solution {
    private static Set<Integer> set;
    
    public static int solution(String numbers) {
        char[] number = numbers.toCharArray();
        boolean[] visited = new boolean[number.length];
        set = new HashSet<>();

        for (int i = 1; i <= number.length; i++) {
            dfs(number, visited, "", i, 0);
        }

        return set.size() - isPrime(set);
    }

    private static int isPrime(Set<Integer> set) {
        int size = 0;

        for (int value : set) {
            if (value == 0 || value == 1) {
                size++;
                continue;
            }

            for (int i = 2; i * i <= value; i++) {
                if (value % i == 0) {
                    size++;
                    break;
                }
            }
        }

        return size;
    }

    private static void dfs(char[] number, boolean[] visited, String now, int idx, int depth) {
        if (idx == depth) {
            set.add(Integer.parseInt(now));
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(number, visited, now + number[i], idx, depth + 1);
                visited[i] = false;
            }
        }
    }
}