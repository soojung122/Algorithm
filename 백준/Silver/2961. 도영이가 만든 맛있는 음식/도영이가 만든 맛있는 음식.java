import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int Min = Integer.MAX_VALUE;
	static boolean[] select;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 테스트의 개수
		
		select = new boolean[N];
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 신말 X
			arr[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛 +

		}
			
		subset(0); //첫번째 재료부터 시작
		System.out.println(Min);
		
	}
	
	//부분집합을 진행할 떄 TFTF로 진행하여 만약 T라면 조합이 되고 그런 식
	static void subset(int srcIdx) { 
		// 기저조건
		if(srcIdx == arr.length) {
			int sin = 1;
			int ssn = 0;
			int cnt = 0; // 사용한 재료의 개수
			
			for(int i=0; i<N; i++) {
				if(select[i]) {
					sin *= arr[i][0];
					ssn += arr[i][1];
					cnt++;
				}
			}
			
			if(cnt > 0)
				Min = Math.min(Min, Math.abs(sin - ssn));
			
			return;

		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
}
