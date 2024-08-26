import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuffer = new StringBuilder();
		int T = Integer.parseInt(bufferedReader.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] tc = bufferedReader.readLine().split("");
            Deque<String> stack = new ArrayDeque<>();

            int count = 1;
            stack.add("(");

            for (int j = 1; j < tc.length; j++) {
                if (tc[j].equals("(")) {
                    stack.add(tc[j]);
                    count++;
                } else if (tc[j].equals(")")) {
                    if (tc[j - 1].equals("(")) {
                        stack.pop();
                        count += stack.size() - 1;
                    } else {
                        stack.pop();
                    }
                }
            }

            stringBuffer.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        
        bufferedWriter.write(String.valueOf(stringBuffer));
        bufferedWriter.flush();
	}
}