
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] sums, memoi;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		memoi = new int[5]; 
        memoi[1] = 1;
        memoi[2] = 2; 
        memoi[3] = 4; 
        memoi[4] = 7;
        
		sums = new int[N];
		for(int i=0; i<N; i++) {
			sums[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 4;
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int need = sums[i];

            if (need >= memoi.length) {
                memoi = Arrays.copyOf(memoi, need + 1);
            }

            for (int j = idx + 1; j <= need; j++) {
                memoi[j] = memoi[j - 1] + memoi[j - 2] + memoi[j - 3];
            }
            idx = Math.max(idx, need);

            sb.append(memoi[need]).append('\n');
        }
        System.out.print(sb);
		
	}

}
