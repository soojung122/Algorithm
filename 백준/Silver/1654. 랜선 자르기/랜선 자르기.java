
import java.io.*;
import java.util.*;

public class Main { 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[K];
		long max = 0;
		
		for(int i=0; i<K; i++) {
			tree[i] = Integer.parseInt(br.readLine());
			if(tree[i] > max) max = tree[i];
		}

		long low = 1, high = max;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			int cnt = 0;
			
			for(int i : tree) {
				cnt += (i / mid);
			}
			
			if(cnt >= N) {
				answer = mid;
				low = mid + 1;
			}
			else
				high = mid - 1;
			
		}
		
		System.out.println(answer);

	}

	
	
	
}
