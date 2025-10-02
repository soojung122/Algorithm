
import java.util.*;
import java.io.*;
/*
 * 높이가 서로 다른 탑 왼 -> 오 / 레이저 신호 오 -> 왼
 * 가장 먼저 만나는 하나의 탑에서만 수신 가능함.
 * 수신한 탑의 번호가 필요함 -> idx
 * stack을 이용해 자신보다 큰 가장 높은 탑만 남긴다.
 */
public class Main {

	static int N;
	static int[] arr; // 수신 index를 담을 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[N+1];
		// 가장 오른쪽부터 와야 하니까.
		for(int i=N; i>0; i--) {
			// now = arr[i];
			
			while(!stack.isEmpty() && stack.peek()[0] < arr[i]) {
				int[] top = stack.pop();
				res[top[1]] = i; 
			}
			
			stack.push(new int[] {arr[i], i});
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++)
			sb.append(res[i]).append(" ");
		
		System.out.println(sb);
	}
		


}
