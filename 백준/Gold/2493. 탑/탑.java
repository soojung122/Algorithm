
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
		
		for(int i=1; i<=N; i++) { // 0 dummy
			int now =  Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()[0] < now) {
				stack.pop(); // 작으면 아무도 못받으니까 삭제
			}
			
			if(!stack.isEmpty())
				arr[i] = stack.peek()[1]; //수신하는 탑의 idx
			else
				arr[i] = 0; 			
			
			stack.push(new int[] {now, i});
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++)
			sb.append(arr[i]).append(" ");
		
		System.out.println(sb);
	}

}
