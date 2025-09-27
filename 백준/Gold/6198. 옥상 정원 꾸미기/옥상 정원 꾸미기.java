import java.util.*;
import java.io.*;

/*
 * 오른쪽만 볼 수 있음
 * 자기의 길이보다 작은 빌딩의 옥상만 볼 수 있음(같은 경우 못봄)
 */
public class Main {
	static int N;
    static long ans;
	static int[] h;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		h = new int[N];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= now) {
				stack.pop();
			}
			ans += stack.size();
//			if(stack.isEmpty())
//				stack.push(now);
//			
//			if(stack.peek() > now) {
//				ans++;
//				stack.push(now);
//			}
			
			stack.push(now);
			
			
		}
		System.out.println(ans);
	}

}
