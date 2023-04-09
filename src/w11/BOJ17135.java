package w11;

import java.io.*;
import java.util.*;

public class BOJ17135 {
	static int N, M, D, small, enemy;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		
		boolean check = false;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(!check && map[i][j] == 1) {
					check = true;
					small = i;
				}
			}
		}
		enemy = 0;
		comb(new int[3], 0, 0);
		System.out.println(enemy);
		
	}

	private static void comb(int[] sel, int idx, int start) {
		if(idx == sel.length) {
			castleDefense(0, 0, sel);
			return;
		}
		
		for(int i = start; i<M; i++) {
			sel[idx] = i;
			comb(sel, idx+1, i+1);
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void castleDefense(int cnt, int death, int[] sel) {
		if(cnt == N-small) {
			System.out.println(death);
			enemy = Math.max(enemy, death);
			return;
		}
		int[][] mapClone = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			mapClone[i] = map[i].clone();
		}
		
		Queue<Point> queue = new LinkedList<>();	
		boolean[][] v = new boolean[N+1][M];
		
		for(int i = 0; i<3; i++) {
			queue.offer(new Point(N, sel[i], 1));
			v[N][sel[i]] = true;
		}
		int kill = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0|| nc>=M || v[nr][nc]) continue;
				
				v[nr][nc] = true;
				if(map[nr][nc] == 1) {
					map[nr][nc] = 0;
					kill++;
					break;
				}else {
					if(p.cnt < D) queue.offer(new Point(nr, nc, p.cnt+1));
				}
			}
		}
		downEnemy();
		castleDefense(cnt+1, death + kill, sel);
		for(int i = 0; i<N; i++) {
			map[i] = mapClone[i].clone();
		}
	}
	
	private static void downEnemy() {
		for(int i = 0; i<M; i++) {
			for(int j = N-1; j>0; j--) {
				map[j][i] = map[j-1][i];
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
