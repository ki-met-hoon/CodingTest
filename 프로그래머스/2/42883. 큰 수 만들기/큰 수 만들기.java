class Solution {
    public static String solution(String number, int k) {
        int start = 0;
        int len = number.length() - k;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int max = -1;

            for (int j = start; j <= i + k; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }
}