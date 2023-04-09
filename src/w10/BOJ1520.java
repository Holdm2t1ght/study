package w10;

import java.io.*;
import java.util.*;

public class BOJ1520 {
	static int N, M, cnt;
	static int[][] map, dpMap;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1520.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dpMap = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dpMap[i][j] = -1;
			}
		}
//		cnt = 0;
//		dfs(0,0, new boolean[N][M]);
		System.out.println(dfsDP(0,0));
	}
	
	private static int dfsDP(int r, int c) {
		if(r == N-1 && c == M-1) {
			cnt++;
			return 1;
		}
		
		if(dpMap[r][c] != -1)
		{
			return dpMap[r][c];
		}
		dpMap[r][c] = 0;
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[r][c]>map[nr][nc]) {
				dpMap[r][c] += dfsDP(nr, nc);
			}
		}
		
		return dpMap[r][c];
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int r, int c, boolean[][] v) {
		if(r == N-1 && c == M-1) {
			cnt++;
			return;
		}
		
		v[r][c] = true;
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && !v[nr][nc] && map[r][c]>map[nr][nc]) {
				dfs(nr, nc, v);
			}
		}
		
		v[r][c] = false;
	}

}
