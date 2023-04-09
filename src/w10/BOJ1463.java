package w10;

import java.io.*;
import java.util.*;

public class BOJ1463 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		System.out.println(dp[n]);
	}

}
