
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] sums, memoi = new int[1001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
        memoi[1] = 1;
        memoi[2] = 2; 
        memoi[3] = 4; 
        memoi[4] = 7;
        
		sums = new int[N];
		for(int i=0; i<N; i++) {
			sums[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            for (int j = 5; j <= sums[i]; j++) {
                memoi[j] = memoi[j - 1] + memoi[j - 2] + memoi[j - 3];
            }
            sb.append(memoi[sums[i]]).append('\n');
        }
        System.out.print(sb);
		
	}

}
