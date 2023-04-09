package w11;

import java.io.*;
import java.util.*;

public class SWEA4014 {
	static int N, X;
	static int [][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/SWEA4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(check(0, i, 1)) {
					cnt++;
				}
				if(check(i, 0, 0)) {
					cnt++;
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}

	}
	
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	private static boolean check(int r, int c, int d) {
		int cnt = 0, difCnt = 1, status = map[r][c];
		boolean isDifferent = false;
		for(int i = 1; i<N; i++) {
			int nr = r + dr[d]*i;
			int nc = c + dc[d]*i;
			if(map[nr][nc] == status) {
				if(isDifferent) {
					cnt++;
					if(cnt == X) {
						isDifferent = false;
						cnt = 0;
					}
				}else difCnt++;
			}else if(map[nr][nc] == status-1) {
				if(isDifferent) return false;
				
				isDifferent = true;
				status = map[nr][nc];
				difCnt = 0;
				cnt++;
			}else if(map[nr][nc] == status+1) {
				if(difCnt < X) return false;
				if(isDifferent) return false;
				
				status = map[nr][nc];
				difCnt = 1;
			}else return false;
			
			
		}
		
		if(isDifferent) return false;
		return true;
	}

}
