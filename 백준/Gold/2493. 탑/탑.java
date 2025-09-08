
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* 
		 * 최악의 경우) 모든 탑들이 오름차순 정렬일 떄 
		 * 완전탐색으로 진행하면 O(N^2)이 발생함.
		 * 올바른 괄호문제를 생각하면 도움이 됨
		 * 가능성이 있는 애들만 남겨두겟다. 
		 * 탑은 높이도 중요하지만, 인덱스도 중요함.
		 */
		int N = Integer.parseInt(br.readLine()); // 탑의 수
		int[] rslt = new int[N];
		
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()[1] < now)
				stack.pop();
			
			// 수신할 수 있는 탑이 없음
			if(stack.isEmpty())
				rslt[i] = 0;
			else {
				rslt[i] = stack.peek()[0] +1;
			}
			
			stack.push(new int[] {i, now});
			
		}
		
		for(int i=0; i<N; i++) {
			bw.write(rslt[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

		
}
