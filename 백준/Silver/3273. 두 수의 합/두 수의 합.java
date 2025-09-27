import java.util.*;
import java.io.*;

public class Main {
	static int N, X, ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		
		/*
		 * 시간 초과 발생
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i] + arr[j] == X) ans++;
			}
		}
		*/
        
        Arrays.sort(arr);
		int i=0, j=N-1;
		while(i < j) {
			int sum = arr[i] + arr[j];
			if(sum == X) { 
				ans++;
				i++;
				j--;
			}
			else if(sum < X) 
				i++;
			else
				j--;
		}
		
		
		
		System.out.println(ans);
	}
	


}
