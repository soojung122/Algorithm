
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int idx = 1;
        
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
				
			// 초기 세팅
			if(stack.isEmpty() || stack.peek() < input) {
				for(int j=idx; j<=input; j++) {
					stack.push(j);
					sb.append("+\n");
					idx = input + 1;
				}
				
			}
			
			if(stack.peek() == input) {
				stack.pop();
				sb.append("-\n");
			}
			else {
				// 스택의 peek보다 input이 큰 경우임.
				sb.setLength(0); //초기화
				sb.append("NO\n");
				break;
			}
			
			
			
		}
		
		bw.write(sb.toString());
		bw.flush();

	}
	
	
	
}
