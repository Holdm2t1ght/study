package w11;

import java.io.*;
import java.util.*;

public class BOJ16919 {
	static int R,C,N;
	static char[][][] map;
	static Queue<Point> queue;
	static boolean check;
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ16919.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C][4];
		
		queue = new LinkedList<>();
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j][1] = s.charAt(j);
				map[i][j][2] = map[i][j][0] = map[i][j][3] = 'O';
				if(map[i][j][1] == 'O') queue.offer(new Point(i, j));
			}
		}
		
		mapStatus();
		print();
	}


	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void mapStatus() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c][3] = '.';
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc][3] =='.') continue;
				
				map[nr][nc][3] = '.';
			}
		}
		
		check = false;
		if(N<5) return;
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j][3] == 'O') {
					check = true;
					queue.offer(new Point(i, j));
				}
			}
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				map[i][j][1] = 'O';
			}
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c][1] = '.';
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc][1] =='.') continue;
				
				map[nr][nc][1] = '.';
			}
		}
	}
	
	private static void print() {
		if(!check && N>=5) {
			if(N%3==0) {
				for(int i = 0; i<R; i++) {
					for(int j = 0; j<C; j++) {
						System.out.print(map[i][j][3]);
					}
					System.out.println();
				}
			}else {
				for(int i = 0; i<R; i++) {
					for(int j = 0; j<C; j++) {
						System.out.print(map[i][j][2]);
					}
					System.out.println();
				}
			}
			
			return;
		}
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				System.out.print(map[i][j][N%4]);
			}
			System.out.println();
		}
		
	}

}
