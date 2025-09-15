
import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visit; //파이프겹치면 안되니까 방문한 곳 표시
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
//		map = new boolean[r][c];
		
		map = new char[R][];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();

		}
		visit = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			if(map[i][0] == 'x') continue;
			if(visit[i][0]) continue; //파이프가 겹치면 안되니까
			
			visit[i][0] = true; //파이프가 시작했다고 표시함.
			if(dfs(i, 0)) // start지점에서 end지점까지 잘 갓다 
				ans++; 
		}
		
		
		System.out.println(ans);

	}
	
	// 우선순위: ↗ → ↘
	static int[] dy = {-1, 0, 1};
	static int[] dx = { 1, 1, 1};

	static boolean dfs(int startR, int startC) { //마지막 열에서 끝나야 하기 때문에
		//기저조건
		if(startC == C-1) {
			return true; // 마지막 열에 도착함.
		}
		
		for(int i=0; i<3; i++) {
			int ny = startR + dy[i];
			int nx = startC + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
			if(visit[ny][nx] || map[ny][nx] == 'x') continue;
			
			visit[ny][nx] = true;
			if(dfs(ny, nx)) return true; //한 경로만 찾으면 되니까
			
		}
		return false;
		
	}
	
//	static boolean isR(int r) {
//		for(int i=0; i<C; i++) { //같은 행이니까 r고정
//			if(map[r][i]=='x' || map[r][i] == 'O')
//				return true;
//		}
//		return false;
//	}
	
//	static int[] dy = {0, -1, 1};  // →, ↗, ↘ (오른쪽을 먼저 시도)
//	static int[] dx = {1,  1,  1};

//	static boolean isDiag(int r, int c) {
//		for(int i=0; i<3; i++) {
//			int ny = r + dy[i];
//			int nx = c + dx[i];
//			
//			while(ny >=0 && nx >=0 && ny < R && nx < C) {
//				if(map[ny][nx] == 'O' || map[ny][nx] == 'x')
//					return true;
//				
//				ny += dy[i];
//				nx += dx[i];
//			}
//		}
//		return false;
//	}
	
	

}
