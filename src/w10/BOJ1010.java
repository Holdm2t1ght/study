package w10;

import java.io.*;
import java.util.*;

public class BOJ1010 {
	static int N, M;
	static long[] memo;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1010.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		memo = new long[31];
		
		memo[1] = 1;
		for(int i = 2; i<=30; i++) {
			memo[i] = memo[i-1]*i;
			System.out.println(memo[i]);
		}

		for(int test_case = 0; test_case < t; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			long ans = 1; 
			if(N!=M) ans = memo[M] / (memo[M-N] * memo[N]);
			System.out.println(ans);
		}
	}

}
