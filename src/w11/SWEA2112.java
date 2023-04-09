package w11;

import java.io.*;
import java.util.*;

public class SWEA2112 {
	static int D, W, K, cnt;
	static int[][] film;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/SWEA2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case<= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = Integer.MAX_VALUE;
			if(K == 1) cnt = 0;
			else dfs(0, 0);
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void dfs(int idx, int count) {
		if(count >= cnt) {
			return;
		}
		
		if(idx == D) {
			if(check()) cnt = Math.min(cnt, count);
			return;
		}
		
		if(check()) {
			cnt = Math.min(cnt, count);
			return;
		}
		dfs(idx+1, count);
		int[] array = film[idx].clone();
		Arrays.fill(film[idx], 0);
		dfs(idx+1, count+1);
		Arrays.fill(film[idx], 1);
		dfs(idx+1, count+1);
		film[idx] = array.clone();
	}

	private static boolean check() {
		for(int i = 0; i<W; i++) {
			int current = film[0][i];
			int count = 1;
			boolean check = false;
			for(int j = 1; j<D; j++) {
				if(count >= K) {
					check = true;
					break;
				}
				
				if(current == film[j][i]) count++;
				else {
					count = 1;
					current = film[j][i];
				}
			}
			if(!check && count<K) return false;
		}
		return true;
	}

}
