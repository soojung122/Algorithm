import java.util.*;
import java.io.*;

public class Main {
    static int N;         
    static char[][] map;      
    static boolean[][] visit; 
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int count;          
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visit = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visit[y][x] && map[y][x] == '1') {
                    count = 0;
                    dfs(y, x);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n"); 
        for (int n : list) sb.append(n).append("\n");
        System.out.print(sb.toString());
    }

    static void dfs(int y, int x) {
        visit[y][x] = true;
        count++; 

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (visit[ny][nx] || map[ny][nx] == '0') continue;

            dfs(ny, nx);
        }
    }
}
