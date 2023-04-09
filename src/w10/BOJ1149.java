package w10;

import java.io.*;
import java.util.*;

public class BOJ1149 {
	static int N;
	static int[][] memo, arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1149.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo = new int[N][3];
		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];
		
		for(int i = 1; i<N;i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + arr[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + arr[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + arr[i][2];
		}
		int min = Math.min(memo[N-1][0], memo[N-1][1]);
		min = Math.min(min, memo[N-1][2]);
		System.out.println(min);
	}
}
