package w10;

import java.io.*;
import java.util.*;

public class BOJ9205 {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int test_case = 0; test_case < t; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			
		}
		
	}

}
