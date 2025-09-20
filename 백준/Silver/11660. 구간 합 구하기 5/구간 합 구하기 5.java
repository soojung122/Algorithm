

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] board;
//	static int[][] number;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) { //행
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) { // 열
				board[i][j] = Integer.parseInt(st.nextToken());
//				dp[i][j] += board[i][j]; //구간 합이 되지 않음.
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + board[i][j]; 
						//전체-좌측-상단+좌상단 
			}
		}
		
//		number = new int[M][4];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) { // M 최대 10만
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]).append("\n");
		}
		
		// 1. 완탐으로 하면 최대 십만X1024X1024가 될 수도 있으니 X!
		// 2. dp를 사용할 때 어떤 걸 할당할지, 베이스케이스는 뭐로 할지
	
		System.out.println(sb);
		
	}

}
