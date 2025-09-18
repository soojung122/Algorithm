
import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] pay;
	static int[][] memoi;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pay = new int[N+1][3]; // R, G, B 순
		memoi = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pay[i][0] = Integer.parseInt(st.nextToken());
			pay[i][1] = Integer.parseInt(st.nextToken());
			pay[i][2] = Integer.parseInt(st.nextToken());

		}
		
		
		//점화식의 초기값
		memoi[1][0] = pay[1][0];
		memoi[1][1] = pay[1][1];
		memoi[1][2] = pay[1][2];
		
		// 2~N R,G,B로 시작한 집에서부터 최선의 선택
		for (int i = 2; i <= N; i++) {
            memoi[i][0] = Math.min(memoi[i-1][1], memoi[i-1][2]) + pay[i][0]; // i 번째에 R 선택 <= i-1 번째 G, B 값중 최소값
            memoi[i][1] = Math.min(memoi[i-1][0], memoi[i-1][2]) + pay[i][1]; // i 번째에 R 선택 <= i-1 번째 G, B 값중 최소값
            memoi[i][2] = Math.min(memoi[i-1][0], memoi[i-1][1]) + pay[i][2]; // i 번째에 R 선택 <= i-1 번째 G, B 값중 최소값
        }
        
        System.out.println( Math.min( Math.min( memoi[N][0], memoi[N][1] ), memoi[N][2] ) );
    }
}