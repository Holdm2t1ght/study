package w10;

import java.io.*;
import java.util.*;

public class BOJ2579 {
	static int[] stairs;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ2579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		stairs = new int[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}
		
		//max = 0;
		//findMaxScore(n-1, 0, 1);
		int[] dp = new int[n];
		if(n > 0) dp[0] = stairs[0];
		if(n > 1) dp[1] = Math.max(stairs[1], stairs[1]+stairs[0]);
		if(n > 2 )dp[2] = Math.max(stairs[2]+stairs[1], stairs[0]+stairs[2]);
		
		if(n>3) {
			for(int i = 3; i<n; i++) {
				dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3] + stairs[i] + stairs[i-1]);
			}
		}
		
		System.out.println(dp[n-1]);
	}

}
