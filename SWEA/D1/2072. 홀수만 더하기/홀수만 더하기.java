import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
                                         
		for(int testCase = 1; testCase <= T; testCase++)
		{
            sb.append("#").append(testCase).append(" ");
            int sum = 0;
            
			String[] temp = br.readLine().split(" ");
            for (int index = 0; index < temp.length; index++) {
            	int num = Integer.parseInt(temp[index]);
                
                if (num % 2 == 1) {
                    sum += num;
                }
            }
                
            sb.append(sum).append("\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
