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
		T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            
            int[][] map = new int[N][N];
            for (int i = 0; i < map.length; i++) {
            	String[] temp = br.readLine().split(" ");
                
                for (int j = 0; j < map[0].length; j++) {
                	map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int val = 0;

                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            val += map[k][l];
                        }
                    }

                    if (val > max) {
                        max = val;
                    }
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
        
        bw.write(String.valueOf(sb));
        bw.flush();
	}
}