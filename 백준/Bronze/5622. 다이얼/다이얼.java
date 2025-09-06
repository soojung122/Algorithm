

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray(); 
//		System.out.println(Arrays.toString(input));
		
		//아이디어#1.  A-65 =0이니까 각 자리의 알파벳에서 -65를 빼서 % 3 == 0이면 1부터 +1씩
		// => 틀린이유는 PQRS = 7인데 4글자씩 들어가있기 때문!
		//#2. switch문 사용할까 A, B, C는 +3이렇게?
		
		int[] arr = {
			    3,3,3,   // A,B,C
			    4,4,4,   // D,E,F
			    5,5,5,   // G,H,I
			    6,6,6,   // J,K,L
			    7,7,7,   // M,N,O
			    8,8,8,8, // P,Q,R,S
			    9,9,9,   // T,U,V
			    10,10,10,10 // W,X,Y,Z
		};
		
		int tot = 0;
		for(int i=0; i<input.length; i++) {
//			int tmp = (input[i] - 65) / 3 + 3; // 숫자 1에 배당된 알파벳이 없으므로
//			start += tmp;
			
			tot += arr[input[i] - 'A'];
		}
		
		System.out.println(tot);

	}

}
