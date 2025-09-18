
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, ans;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1]; //0 dummy
		for(int i=1; i<= N; i++) {
			String line = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(arr[i][j] != 0) {
					arr[i][j] = Math.min(arr[i-1][j], arr[i-1][j-1]);
					arr[i][j] = Math.min(arr[i][j], arr[i][j-1]) + 1;
					ans = Math.max(ans,  arr[i][j]);
				}
			}
		}

		System.out.println(ans * ans);
	}

}
