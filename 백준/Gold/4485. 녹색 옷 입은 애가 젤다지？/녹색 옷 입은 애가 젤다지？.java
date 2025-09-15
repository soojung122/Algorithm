
import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int[][] cost; //(0, 0) -> y, x 좌표로 가는 최소비용을 관린
	
	static final int INF = Integer.MAX_VALUE; //작은 값으로 갱신될 수 있도록
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
	
	static StringBuilder sb = new StringBuilder();
	
	static class Vertex{
        int y; // y
        int x; // x
        int c; // 시작 좌표부터 (y,x) 까지의 최소 비용
        
        Vertex(int y, int x, int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = 1;
	        
        while(true) {
            // 테케 마다 반복
            N = Integer.parseInt(br.readLine());
            if( N == 0 ) break;
            
            map = new int[N][N];
            cost = new int[N][N];
            
            // 입력
            for (int i = 0; i < N; i++) { // 행
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) { // 열
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = INF;
                }
            }
            
            // 다익스트라
            cost[0][0] = map[0][0]; // 첫 번째 방문도 비용 발생 가능
            pqueue.offer(new Vertex(0, 0, map[0][0]));
            
            while( ! pqueue.isEmpty() ) {
                
                Vertex vertex = pqueue.poll();
                
                if( cost[vertex.y][vertex.x] < vertex.c ) continue;
                
                // 사방탐색
                for (int d = 0; d < 4; d++) {
                    int ny = vertex.y + dy[d];
                    int nx = vertex.x + dx[d];
                    if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
                    
                    if( cost[ny][nx] > vertex.c + map[ny][nx] ) {
                        cost[ny][nx] = vertex.c + map[ny][nx];
                        pqueue.offer(new Vertex(ny, nx, cost[ny][nx]));
                    }
                }
            }
            
            // Problem 1: 20
            sb.append("Problem ").append(t).append(": ").append(cost[N-1][N-1]).append("\n");
            t++;
        }
        System.out.println(sb);
    }
}
