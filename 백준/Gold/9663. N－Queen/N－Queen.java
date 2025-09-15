

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[][] board;
	static int cnt; // 경우의 수

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		
		
		// 1. 행에 넣으면 넘어가야함.
		// 2. 열에 넣으면 그 열도 넘어가야 함.
		// 3. 대각선도 넘어가야함.
		
		dfs(0);
		System.out.println(cnt);
		
		
		
	}

	// 어차피 N개의 퀸을 두려면 행에 하나씩 둬야 함.
//	static boolean isR(int r){ //이 행에 있냐
//		for(int i=0; i<N; i++) {
//			if(board[r][i])
//				return true;
//		}
//		return false;
//	}
	
	static boolean isL(int c){ // 이 옇에 있냐
		for(int i=0; i<N; i++) {
			if(board[i][c])
				return true;
		}
		return false;
	}
	
	static void dfs(int r) {
		if(r == N) {
			cnt++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			if(isL(c)) continue; //같은 열에 이미 퀸있음.
			if(isDiag(r, c)) continue; //대각선에 있음
			
			board[r][c] = true;
			dfs(r+1);
			board[r][c] = false;
		}
		
	}
	
	static int[] dy = {-1, -1, 1, 1};
	static int[] dx = {-1, 1, -1, 1};
	
	static boolean isDiag(int r, int c) {
		for(int i=0; i<4; i++) {
			int ny = dy[i] + r;
			int nx = dx[i] + c;
			
			while(0 <= ny && ny < N && 0 <= nx && nx < N) {
				
				if(board[ny][nx]) return true;
				ny += dy[i];
				nx += dx[i];
			}
			
		}
		
		return false;
	}
	
	

}
