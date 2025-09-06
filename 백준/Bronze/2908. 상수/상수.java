
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int rN = 0;
		int rM = 0; 
		for(int i=0; i<3; i++) {
			rN = rN * 10 + (N % 10);
			rM = rM * 10 + (M % 10);
			
			N /= 10;
			M /= 10;
		}
		
		int answer = Math.max(rN, rM);
		System.out.println(answer);

	}

}
