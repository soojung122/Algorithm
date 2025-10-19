import java.io.*;
import java.util.*;

/*
 * 
 */
public class Main {
	static int T, N;
	static int[] P;
	static boolean[] Visit; // 방문 여부 확인
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		T = Integer.parseInt(br.readLine()); // 테케 수
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine()); // 각 테케의 순열 크기
			P = new int[N+1]; // 0 dummy
			Visit = new boolean[N+1];
			int ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) { // 순열 입력받기
				P[j] = Integer.parseInt(st.nextToken());
			}
			
			// 순열 사이클
			for(int j=1; j<=N; j++) {
				if(!Visit[j]) {
					int now = j; // 매칭은 1부터 N
					while(!Visit[now]) {
						Visit[now] = true; // 방문함
						now = P[now]; // 입력된 순열과 연결
					}
					ans++; // 연결을 누적해서 하나의 사이클을 만들기 위함
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
