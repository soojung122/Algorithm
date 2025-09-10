
import java.io.*;
import java.util.*;

public class Main {
		
	static int N, r, c, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 2^N
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        N = 1 << N; // 2<<N이 아니라 1이 맞음. 2의N승이니가.
        
        // 원점
        int y = 0;
        int x = 0;
        
        while(true) {
            if( N == 1 ) break;
            
            // 4등분
            N /= 2;
            
            if( r < y + N && c < x + N ) { // 왼쪽 위
                ;
            }else if( r < y + N && c >= x + N ) { // 오른쪽 위
                ans += N * N * 1;
                x += N;
            }else if( r >= N && c < x + N ) { // 왼쪽 아래
                ans += N * N * 2;
                y += N;
            }else { // 오른쪽 아래
                ans += N * N * 3;
                y += N;
                x += N;
            }
        }
        
        System.out.println(ans);
    }
}
