

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		// 기존의 for문과 아래의 for문은 가독성이 향상된 것 뿐 속도의 유의미한 차이는 없다.
		// 근데 
//		for(int i : input)
//			System.out.println(i);
		// StringTokenizer를 줄마다 새로 만들고, System.out.println을 N번 쓰면 시간초과됨.
		/*
		 출력 또한 BufferedWriter를 사용하거나 StringBuilder로 한 번에 출력해야한다.
		그리고 해당 문제에 대해 살짝 팁을 드리자면 Arrays.sort는 무조건 시간초과 발생.
		 */
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
			sb.append(input[i] + "\n");
		
		System.out.println(sb);

	}

}
