import java.util.*;
import java.io.*;

// N개의 수를 순서대로 나열하기만(뽑기X)

public class Main {
	static int N;
	static int[] nums;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		select = new boolean[N];
		nums = new int[N];
		
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int tgtidx) {
		if(tgtidx == select.length) {
//			sb.append(Arrays.toString(nums)).append("\n");
			for(int i=0; i<nums.length; i++)
				sb.append(nums[i]).append(' ');
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(select[i] ) continue;
			
			nums[tgtidx] = i+1; 
			select[i] = true;
			perm(tgtidx+1);
			select[i] = false;
		}
	}
}
