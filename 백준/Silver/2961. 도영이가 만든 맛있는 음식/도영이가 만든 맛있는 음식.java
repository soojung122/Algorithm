import java.util.*;
import java.io.*;

/*
 * 물은 요리로 count X -> 재료를 count해야 함.
 * 신맛과 쓴맛의 차이가 가장 작은 요리
 */
public class Main {
	static int N;
	static int Min = Integer.MAX_VALUE;
	static int[][] cook;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cook = new int[N][2];
		select = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cook[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			cook[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		subset(0);
		System.out.println(Min);
	}

	static void subset(int idx) {
		if(idx == N) {
			int sin = 1; // 곱
			int ssn = 0; // 합
			int cnt = 0; // 재료의 개수
			
			for(int i=0; i<N; i++) {
				if(select[i]) { // 재료가 선택된 경우에만
					sin *= cook[i][0];
					ssn += cook[i][1];
					cnt++;
				}
			}
			if(cnt > 0) { // 한 개이상
				Min = Math.min(Min, Math.abs(sin - ssn));
			}
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		
		select[idx] = false;
		subset(idx+1);
		
	}
}
