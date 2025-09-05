import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// 한 사이트에는 하나의 다리만 연결가능
		// N개만틈 다리를 지을려고 함. 중복X
		// M개 중 N개를 골라야 함 = 조합
		// 출력: 다리의 개수X, 다리를 지을 수 있는 경우의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long answer;
		
		int cnt = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수
//		System.out.println(N);
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N의 개수
			int M = Integer.parseInt(st.nextToken()); // M의 개수

			
			answer = comb(M, N);
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}
	
	static long comb(int srcIdx, int tgtIdx) {
		// 기저조건
		long r = 1;
		 for (int i = 1; i <= tgtIdx; i++) {
	            r = r * (srcIdx - i + 1) / i;
	        }
		return r;
	}
	
}
