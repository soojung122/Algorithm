
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int answer = -1;
		int cnt5=0, cnt3=0;
		
		while(N>=0) {
			
			if (N % 5 == 0) {           
		        answer = cnt3 + (N / 5);
		        break;
		    }
		    N -= 3;                 
		    cnt3++;
			
		}	

		System.out.println(answer);
	}

}
