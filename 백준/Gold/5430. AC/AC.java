import java.util.*;
import java.io.*;

public class Main {
	
	static int T, N; // 테케의 수, 배열의 수
	static String[] P; // 수행할 함수
	static int[] arr; // 기존 정수 배열
	static Deque<Integer> q;
	static StringBuilder sb = new StringBuilder(); // 최종 배열 출력
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			P = br.readLine().split(""); //현재 문자 상태
			N = Integer.parseInt(br.readLine());
			
			String line = br.readLine();
			line = line.substring(1, line.length() - 1);
			q = new ArrayDeque<>();
			if (N > 0) {
				for (String s : line.split(",")) 
					q.add(Integer.parseInt(s));
			}
			
			boolean flag = false;
			boolean error = false;
			for(int i=0; i<P.length; i++) {
				if(P[i].equals("R")) 
					flag = !flag;	
				else { // D일 때
					if(q.isEmpty()) {
						sb.append("error\n");
						error = true;
						break;
					}
					D(flag); // flag 정보를 알아야 함.
					
				}
			}
			
			if(!error) { // 마지막일 때 q가 비어있다면 []만 출력해야 함. -> error상황과 empty를 구분이 필요
				arr = new int[q.size()];
				int idx = 0;
				for(int n: q)
					arr[idx++] = n;
				if(flag) R();
				sb.append(Arrays.toString(arr).replace(" ", "")).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	static void R() {
		// 배열에 들어있는 정수 1<= X <= 100
		for(int i=0; i<arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		}
		
	}
	
	static void D(boolean f) {
		if(!f)
			q.pollFirst();
		else
			q.pollLast();	
	}
}
