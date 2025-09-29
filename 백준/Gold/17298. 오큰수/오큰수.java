import java.util.*;
import java.io.*;

/*
 * 오큰수 = cur보다 오른쪽에 위치 + 값이 커야함 + 앞의 조건을 만족하며 가장 왼쪽
 * N 최대 크기 백만, 수열의 원소 최대 크기 백만 => 이중 for문 실행시 시간초과 발생
 * cur보다 작으면 pass, 크면 peek()과 비교해가며 push하여 위의 조건을 만족하는 스택만 남겨 pop()
 * Q1. 입력받는 배열이 필요할까? 바로 cur과 peek()으로 처리 가능할 듯.
 * Q2. prev 변수가 필요할까? 필요없음. 인덱스 값을 기억해야 함. 가장 왼쪽 처리 위해서.
 * Q3. -1 처리는 어떻게 할까? -1이 초반에 생기는 경우도 있어서 배열이 필요함.
 */
public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1]; // 0 dummy
		Arrays.fill(arr, -1); 
		
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<=N; i++) {
			int cur = Integer.parseInt(st.nextToken()); // 현재 값
			
			while(!stack.isEmpty() && stack.peek()[1] < cur ) {
				int[] top = stack.pop();
//				sb.append(cur).append(" "); // 5
				arr[top[0]] = cur;
			}
			
			stack.push(new int[] {i, cur}); // (1, 3) -> (2, 5) -> (3, 2) -> (4, 7)
		}
		
		for(int i=1; i<= N; i++)
			sb.append(arr[i]).append(" ");
		System.out.println(sb);
	}

}
