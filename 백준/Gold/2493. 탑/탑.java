
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		int[] rslt = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 낮은 탑은 모두 pop이 필요함
			while(!stack.isEmpty() && stack.peek()[0] < now) {
				stack.pop();
			}
			
			if(stack.isEmpty())
				rslt[i] = 0;
			else {
				rslt[i] = stack.peek()[1] +1;
			}
			
//			stack.push(now[i+1]);
			stack.push(new int[] {now, i});
		}
		
		for(int i=0; i<N; i++) 
			bw.write(rslt[i] + " ");
		bw.flush();
		
	}

}
