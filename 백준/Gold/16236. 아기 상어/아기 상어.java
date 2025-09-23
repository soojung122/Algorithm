
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;
    
    // bfs
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visit;
    
    // delta - 상-하-좌-우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 9 ) {
                    sy = i; sx = j;
                }
                map[i][j] = n;
            }
        }
        // 시물레이션
        sSize = 2; // 최초 아기상어의 크기
        
        while(true) {
            
            int dis = bfs();
            if( dis == 0 ) break; // 더 이상 물고기를 먹을 수 없다. ( != map 의 모든 물고기를 먹었다.)
            ans += dis; // 누적 거리
        }
        
        System.out.println(ans);
    }
    // 현재 아기상어 위치에서 가장 가까운 물고기를 찾는데 걸린 시간 (= 이동한 거리)을 구하고 리턴
    //
    static int bfs() {
        
        // 먹이 후보
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;
        
        // visit 초기화 <= bfs() 반복 호출되므로 항상 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }
        
        // 탐색 시작 좌표부터 queue 에 넣고 bfs() 시작
        visit[sy][sx] = true;
        queue.offer(new Node(sy, sx, 0));
        
        while( ! queue.isEmpty() ) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            int d = node.d;
            
            // 꺼낸 Node 가 물고기이고, 상어보다 크기가 작으면  
            if( map[y][x] != 0 && map[y][x] < sSize ) {
                
                if( d < minDis ) {
                    minDis = d;
                    minY = y;
                    minX = x;
                }else if( d == minDis ) {
                    if( y < minY ) {
                        minDis = d;
                        minY = y;
                        minX = x;
                    }else if( y == minY ) {
                        if( x < minX ) {
                            minDis = d;
                            minY = y;
                            minX = x;
                        }
                    }
                }// end if-else
            }// end if
            
            // 가지치기
            if( d + 1 >= minDis ) continue; 
                
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 범위 체크, visit 체크, 물고기 크기 체크
                if( ny < 0 || nx < 0 || ny >= N || nx >= N 
                        || visit[ny][nx] || map[ny][nx] > sSize ) continue;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, node.d + 1));
            }
        }
        
        if( minDis == Integer.MAX_VALUE ) return 0;
        else {
            sEatCnt++; // 물고기 먹은 수를 증가
            if( sEatCnt == sSize ) {
                sSize++;
                sEatCnt = 0;
            }
            
            map[minY][minX] = 0; // 먹은 물고기 빈칸
            map[sy][sx] = 0;
            
            // 새로운 상어의 자리 = 먹은 자리
            sy = minY;
            sx = minX;
        }
        
        return minDis;
    }
    
    static class Node{
        int y, x, d; // 좌표, 상어위치부터의 거리
        
        Node(int y, int x, int d){
            this.y = y; this.x = x; this.d =d;
        }
    }
}
