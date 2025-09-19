
import java.util.*;
import java.io.*;

public class Main{
	static int K, W, H, ans; // 말처럼 움직일 수 있는 횟수, 가로, 세로 길이
	static int[][] board;
	static boolean[][][] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		//입력
		board = new int[H][W];
		visit = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
//				board[i][j] = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				board[i][j] = n;
			}
		}
		
		// Q1. 언제 말처럼 이동하는 게 횟수감소에 영향을 주나? -> 상관없을지도,,,
		// Q2. 시간과 W,H를 보면 완탐을 하는 문제는 아닌 것 같은데..
		// => 완탐의 기준이 압력크기X경우의 수X연산당 시간을 따짐 -> 자바는 1초에 약 10^8 가능
		// 완탐될 것 같은데. 200X200
		
		ans = bfs();
		System.out.println(ans);

	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int bfs() {
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.y == H-1 && node.x == W-1)
				return node.dist;
			
			for(int d=0; d<4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny<0 || nx<0 || ny >=H || nx >= W || board[ny][nx] == 1) continue;
				
				if(!visit[ny][nx][node.used]) {
					visit[ny][nx][node.used] = true;
					queue.offer(new Node(ny, nx, node.used, node.dist+1));
				}

			}
			
			if(node.used < K) {
				for(int i=0; i<8; i++) {
					int ny = node.y + Hdy[i];
					int nx = node.x + Hdx[i];
					
					if(ny <0 || nx <0 || ny >= H || nx >= W || board[ny][nx] == 1) continue;
					
//					node.used += 1;
					// 루프안에서 조건없이 증가시키고 있어서.. bfs는 시도할 때마다 +1이 되어야 하기 때문에
					if(!visit[ny][nx][node.used+1]) {
						visit[ny][nx][node.used+1] = true;
						queue.offer(new Node(ny, nx, node.used+1, node.dist+1));
					}
				}	
			}
			
		}
		
		
		return -1;
		
		
	}
	
	
	//말의 이동
	static int[] Hdy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] Hdx = {-1, -2, -2, -1, 1, 2, 2, 1};
	
//	//r,c의 위치에서 말처럼 이동해서 다른 칸으로 이동할 수 있는지의 여부확인
//	static boolean checkHorse(int y, int x) { 
//		for(int i=0; i<8; i++) {
//			int ny = y + Hdy[i];
//			int nx = x + Hdx[i];
//			
//			if(ny <0 || nx <0 || ny >= H || nx >= W || !visit[ny][nx]) continue;
//			
//			//방문한 곳이니까 재방문X
//			
//			visit[ny][nx] = true;
//			board[ny][nx] = 1;
//			
//			//true의 조건을 뭐로 해야 하지..?
//			
//		}
//		
//		return false;
//	}
	
	static class Node{
		int x, y, used, dist;
		
		Node(int y, int x, int used, int dist){
			this.y=y;this.x=x; 
			this.used = used; this.dist=dist;
		}
	}
}
