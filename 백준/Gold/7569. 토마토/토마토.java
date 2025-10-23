import java.util.*;
import java.io.*;

/*
 * 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다.
 * 
 */
public class Main {
	static int M, N, H, ansDay;
	static int[][][] boxs;
	static boolean[][][] visited;
	
	//위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향
	static int[] dy = {-1, 1, 0, 0, 0, 0}; //상하
	static int[] dx = {0, 0, -1, 1, 0, 0}; // 좌우
	static int[] dz = {0, 0, 0, 0, -1, 1}; // 앞 뒤
	
	static Queue<Node> queue = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //가로 칸
		N = Integer.parseInt(st.nextToken()); //세로 칸
		H = Integer.parseInt(st.nextToken()); //높이
		
		boxs = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		for(int z=0; z<H; z++) {
			for(int i=0; i<N; i++) { //행
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) { // 열
					boxs[z][i][j] = Integer.parseInt(st.nextToken());
					if(boxs[z][i][j] == 1) {
						queue.offer(new Node(i, j, z));
						visited[z][i][j] = true;
					}
				}
			}
		}
		
		int maxDay = 1;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int k=0; k<6; k++) {
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];
				int nz = cur.z + dz[k];
				
				if(ny <0 || ny>=N || nx<0||nx>=M || nz<0 || nz>=H) continue;
				if (visited[nz][ny][nx]) continue;
				if(boxs[nz][ny][nx] != 0) continue;
				
				boxs[nz][ny][nx] = boxs[cur.z][cur.y][cur.x]+1;
				maxDay = Math.max(maxDay, boxs[nz][ny][nx]);
				
				visited[nz][ny][nx] = true;
				queue.offer(new Node(ny, nx, nz));
			}
		}
		
		for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (boxs[z][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(maxDay - 1);

	}
	
	static class Node {
        int y, x, z;
        Node(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }

}
