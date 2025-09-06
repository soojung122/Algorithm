import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// int의 범위가 +-21억이니까 입력으로 주어지는 걸 잘 따져봐야겠다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //테케 개수
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int r = Integer.parseInt(st.nextToken()); // 반복 횟수 r
			char[] input = st.nextToken().toCharArray();
			
//			System.out.println(Arrays.toString(input));
			
			for(int j=0; j<input.length; j++) {
				sb.append(String.valueOf(input[j]).repeat(r)); 
//				System.out.print(input[j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
