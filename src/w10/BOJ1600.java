package w10;

import java.io.*;
import java.util.*;

public class BOJ1600 {
	static int K, W, H, min;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1600.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = -1;
		bfs();
		System.out.println(min);
	}
	static class Point{
		int r, c, cnt, k;

		public Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] hr = {-1,-2,-2,-1,1,2,2,1};
	static int[] hc = {-2,-1,1,2,-2,-1,1,2};

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] v = new boolean[H][W][K+1];
		queue.offer(new Point(0,0,0,K));
		v[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == H-1 &&p.c==W-1) {
				min = p.cnt;
				return;
			}
			if(p.k > 0) {
				for(int d = 0; d<8; d++) {
					int nr = p.r + hr[d];
					int nc = p.c + hc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && !v[nr][nc][p.k-1]  && map[nr][nc]!=1) {
						v[nr][nc][p.k-1] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, p.k-1));
					}
				}
				for(int d = 0; d<4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && !v[nr][nc][p.k] && map[nr][nc]!=1) {
						v[nr][nc][p.k] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, p.k));
					}
				}
			}else {
				for(int d = 0; d<4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && !v[nr][nc][0] && map[nr][nc]!=1) {
						v[nr][nc][0] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, p.k));
					}
				}
			}
		}
		
	}

}
