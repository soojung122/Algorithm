
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S;
	static boolean[] select;
	static int[] arr;
	static int CNT;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken()); // 합
		
		arr = new int[N];
		select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(CNT);
		
	}
	static void subset(int idx) {
		if(idx == N) {
			int sum = 0;
			boolean flag = false;
			
			for(int i=0; i<N; i++) {
				if(select[i]) {
					sum += arr[i];
					flag = true;
				}
			}
			
			if(sum == S && flag) {
				CNT++;
//				System.out.println(Arrays.toString(select));
				// 아무것도 선택하지 않았을 때도 0으로 카운팅되는 군
			}
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		
		select[idx] = false;
		subset(idx+1);
	}

}
