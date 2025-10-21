import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] S; // 능력치 조합
	static boolean[] select; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); // 축구원
		
		S = new int[N][N];
		select = new boolean[N];
		for(int i=0; i<N; i++) { // 능력치 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        S[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		dfs(0, 0, 0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int idx, int cnt, int sSum, int lSum) {
		// 기저 조건
		if(cnt > N/2) return; // 팀원을 반반으로 나눠야 함.
		if(idx - cnt > N/2) return; 
		
		if(idx == N) {
			if(cnt == N/2) {
				ans = Math.min(ans, Math.abs(sSum-lSum));
			}
			return;
		}
		
		// (1) 스타트 팀
		int sTeam = 0;
		for(int j=0; j<idx; j++) {
			if(select[j]) {
				sTeam += S[idx][j] + S[j][idx];
			}
		}
		select[idx] = true;
		dfs(idx+1, cnt+1, sSum+sTeam, lSum);
		
		int lTeam = 0;
		for(int j=0; j<idx; j++) {
			if(!select[j]) {
				lTeam += S[idx][j] + S[j][idx];
			}
		}
		select[idx] = false;
		dfs(idx+1, cnt, sSum, lSum+lTeam);
		
	}

}
