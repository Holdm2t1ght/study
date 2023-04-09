package w11;

import java.io.*;
import java.util.*;

public class BOJ3055 {
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ3055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String s= br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		goTo();
		System.out.println("KAKTUS");
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

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void goTo() {
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> water = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] == '*') {
					water.offer(new Point(i, j, 0));
					v[i][j] = true;
				}else if(map[i][j]=='S') {
					queue.offer(new Point(i, j, 0));
					v[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			while(!water.isEmpty()) {
				if(water.peek().cnt == p.cnt) {
					Point w = water.poll();
					for(int d = 0; d<4; d++) {
						int nr = w.r + dr[d];
						int nc = w.c + dc[d];
						
						if(nr>=0 && nr<R && nc>=0 && nc<C && !v[nr][nc]) {
							if(map[nr][nc] == '.'||map[nr][nc]=='S') {
								v[nr][nc] = true;						
								water.offer(new Point(nr, nc, p.cnt+1));
							}else if(map[nr][nc] == 'X') {
								v[nr][nc] = true;
							}
						}
					}
				}else break;
			}
			
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C && !v[nr][nc]) {
					if( map[nr][nc] == 'D') {
						System.out.println(p.cnt+1);
						System.exit(0);
					}else if(map[nr][nc] == '.') {
						v[nr][nc] = true;						
						queue.offer(new Point(nr, nc, p.cnt+1));
					}else if(map[nr][nc] == 'X') {
						v[nr][nc] = true;
					}
				}
			}
		}
	}
		
	

}
