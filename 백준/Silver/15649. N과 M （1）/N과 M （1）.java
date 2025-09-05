

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] src;
	static int[] tgt; // 전역변수로 선언하고 크기는 나중에 할당 가능함.
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// 순열
		// 중복X 1 ~ N
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		System.out.println(N + " " + M);
		
		src = new int[N]; //0으로 초기화되어있음.
		for(int i=0; i<N; i++) {
			src[i] = i+1;
		}
		tgt = new int[M];
		select = new boolean[src.length];
		
//		System.out.println(Arrays.toString(input));
		Perm(0);
		System.out.println(sb);
	}

	static void Perm(int tgtIdx) { //채우고자 하는 tgt 배열의 인덱스 값을 전달하는 것임
		// 기저조건
		if(tgtIdx == tgt.length) {
			for (int i = 0; i < tgt.length; i++) {
	            sb.append(tgt[i]).append(" ");
	        }
	        sb.append("\n");
			return;
		}
		
		// tgt에 채우기
		for(int i=0; i<src.length; i++) {
			if(select[i] == true) continue; // 이미 사용한 것이기 때문에! => 순열은 중복없이!
			
			tgt[tgtIdx] = src[i];
			select[i] = true; // 사용했으니까
			Perm(tgtIdx+1); // 재귀호출에서는 +1과 ++을 주의해서 사용해야 한다.
			select[i] = false; //다음 자리에서는 다시 세어야 하니까
		}
	}
}
