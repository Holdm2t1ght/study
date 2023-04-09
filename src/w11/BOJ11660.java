package w11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		for(int i = 1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<n+1;j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = map[i-1][j] + map[i][j-1] + a - map[i-1][j-1];
			}
		}
		for(int j = 0;j<m;j++) {
			st = new StringTokenizer(br.readLine());
			int[] startLimit = new int[4];
			for(int i = 0;i<4;i++) {
				startLimit[i] = Integer.parseInt(st.nextToken());
			}
			int ans = map[startLimit[2]][startLimit[3]]
					- map[startLimit[0]-1][startLimit[3]]
					- map[startLimit[2]][startLimit[1]-1]
					+ map[startLimit[0]-1][startLimit[1]-1];
			
			bw.write(ans + "\n");
			bw.flush();
		}
		
	}

}