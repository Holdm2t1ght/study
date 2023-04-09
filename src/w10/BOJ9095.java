
package w10;

import java.io.*;
import java.util.*;

public class BOJ9095 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
			
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i<=10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		
		for(int i = 0; i< t ;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(dp[n]);
		}
		
	}

}
