
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean flag = true;
			
			for(char ch : str.toCharArray()) { // 매줄 초기화되어야하므로
				
				if(ch == '(') 
					stack.push(ch);
				else {
					if(stack.isEmpty() || stack.pop() == ')') {
						flag = false;
						break;
					}
						
					
				}
				
			}
			
			if(flag && stack.isEmpty())
				bw.write("YES\n");
			else
				bw.write("NO\n");
			
			
			
		}
		
		
		bw.flush();

	}

}
