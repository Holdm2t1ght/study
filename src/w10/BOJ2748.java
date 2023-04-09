package w10;

import java.io.*;
import java.util.*;

public class BOJ2748 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ2748.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		if(n >= 2) {
			for(int i = 2; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[n]);
	}

}
