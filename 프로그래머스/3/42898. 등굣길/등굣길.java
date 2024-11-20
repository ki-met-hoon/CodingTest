class Solution {
     private static final int MOD = 1000000007;  
  
    public int solution(int m, int n, int[][] puddles) {  
        // 각 지점까지 이동하는 최단 경로의 수를 저장할 dp 배열  
        int[][] dp = new int[n + 1][m + 1];  
        // 웅덩이가 있는 위치는 -1로 초기화  
        for (int[] puddle : puddles) {  
            dp[puddle[1]][puddle[0]] = -1;  
        }  
  
        for (int i = 1; i <= n; i++) {  
            for (int j = 1; j <= m; j++) {  
                // 시작점은 1로 초기화  
                if (i == 1 && j == 1) {  
                    dp[i][j] = 1;  
                }  
                // 웅덩이가 있는 위치라면, 해당 위치의 경로의 수는 0으로 초기화
                if (dp[i][j] == -1) {  
                    dp[i][j] = 0;  
                    continue;  
                }  
  
                // 위에서 온 경로의 수와 왼쪽에서 온 경로의 수를 더해준다.  
                if (i != 1) {  
                    dp[i][j] += dp[i - 1][j] % MOD;  
                }  
                if (j != 1) {  
                    dp[i][j] += dp[i][j - 1] % MOD;  
                }  
            }  
        }  
  
        return dp[n][m] % MOD;  
    }  
}