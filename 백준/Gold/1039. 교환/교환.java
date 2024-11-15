import java.util.*;
import java.io.*;

public class Main {
	static int memo[][];
	static int K;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String N = st.nextToken();
		K = Integer.parseInt(st.nextToken());
		M = N.length();

		memo = new int[K + 1][1000001];
		
		System.out.println(DFS(N, 0));
	} // End of main

	private static int DFS(String strN, int depth) {
		
		int num = Integer.parseInt(strN);
		if (depth == K) {
			return num;
		}

		int memoValue = memo[depth][num];
		if (memoValue != 0) {
			return memoValue;
		}

		memoValue = -1; // 불가능할 경우 -1을 가져오기 위해 -1로 초기화
		for (int i = 0; i < M - 1; i++) {
			for(int j=i+1; j<M; j++) {
				if(i == 0 && strN.charAt(j) == '0') { // 바꾸려고 할 때, 첫번째 자리 0이 들어오려고 하면, 그냥 넘어감.
					continue;
				}
				
				String swapStr = swap(strN, i, j);
				
				int temp = DFS(swapStr, depth + 1);
				memoValue = Math.max(memoValue, temp);
			}
		}

		memo[depth][num] = memoValue;		
		return memo[depth][num];
	} // End of DFS

	private static String swap(String str, int i, int j) {
		char chArr[] = str.toCharArray();
		char temp = chArr[i];
		chArr[i] = chArr[j];
		chArr[j] = temp;
		return String.valueOf(chArr);
	} // End of swap
} // End of Main class