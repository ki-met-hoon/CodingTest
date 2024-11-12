import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(br.readLine()).append(" ");
            
            int[] scoreBoard = new int[101];
            String[] totalScore = br.readLine().split(" ");
            
            for (int i = 0; i < totalScore.length; i++) {
            	int score = Integer.parseInt(totalScore[i]);
                scoreBoard[score]++;
            }
            
            int max = Integer.MIN_VALUE;
            int ans = 0;
            
            for (int i = 0; i < scoreBoard.length; i++) {
            	if (scoreBoard[i] >= max) {
                	max = scoreBoard[i];
                    ans = i;
                }
            }
            
            sb.append(ans).append("\n");
		}
        
        bw.write(String.valueOf(sb));
        bw.flush();
	}
}