import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int M, N, answer;
	static Queue<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		// 방사형 진행 -> 무조건 bfs 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //row
		N = Integer.parseInt(st.nextToken()); // column
		
		map = new int[N][M];
//		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//익은 토마토가 있다면 큐에 추가함.
				if(map[i][j] == 1)
					queue.add(new int[] {i, j});
			}
		}
//		System.out.println(map[N-1][M-1]);
		
		bfs();
		int rslt = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//bfs를 다 돌았음에도 익지 않은 토마토가 있다면
				if(map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				
				
				rslt = Math.max(rslt, map[i][j]);
				
				
			}
		}
		
		System.out.println(rslt-1); //1부터 시작했음으로..?문제는 0에서 시작하니까-1

	}
	
	//상하좌우 순서
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void bfs() {
		while(!queue.isEmpty()) {
			//현재 익은 토마토 위치
			int[] current = queue.poll();
			int y = current[0];
			int x = current[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny <0 || nx < 0 || ny > N-1 || nx > M-1  || map[ny][nx] != 0)
					// 0인 경우만 익음
					continue;
				
				map[ny][nx] = map[y][x] + 1; //익은 날짜를 누적이니까 지금에서 +해줘야함.
				queue.add(new int[] {ny, nx});

			}
		}
		
	}
	
}
