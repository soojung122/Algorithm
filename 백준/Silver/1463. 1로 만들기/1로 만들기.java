import java.util.*;
import java.io.*;

/*
 * 10 -> 5 -> 4 -> 2 -> 1 = 4번
 * 10 -> 3 -> 2 -> 1 = 3번
 * 2로 할 때가 더 최소인지, 3일 때가 더 최소인지 비교할 방법을 찾아야 함.
 * 둘 다 비교해서..? 둘 다 해보고 더 작은 애를 dp값에 넣어야 함.
 * dp는 확실하게 값이 이미 정해져있으면 그 값을 사용해야 함.
 */
public class Main {
	
	static int N, count;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		dp = new int[N+1];
		
		dp[1] = 0; // 1은 결과니까 count하지 않음.
		
		for(int i = 2; i<= N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			if(i % 3 ==0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		
		System.out.println(dp[N]);
		
//		int idx = 3;
//		int n2 = Integer.MAX_VALUE; // 2일 경우 몫
//		int n3 = Integer.MAX_VALUE; // 3일 경우 몫
//		
//		while(idx <= N) {
//			
//			if(N % 2 == 0) 
//				n2 = N / 2;
//			if(N % 3 == 0)
//				n3 = N/3;
//			
//			int min = Math.min(n2, n3);
//			dp[idx++] = min; //최솟값을 넣는 거니까
//			N /= (n2 > n3) ? 3 : 2;
//			count++;
//			
//			N -= 1;
//			count++;
//			
//		}
		
		
		
//		while(true) {
//			
//			if(N % 2 == 0) {
//				N /= 2;
//				count++;
//				
//			}
//			else if(N % 3 == 0) {
//				N /= 3;
//				count++;
//				
//			}
//			
//			if(N == 1) {
//				break;
//			}
//			 N -= 1;
//			 count++;
//
//				
//		}
		
		
//		System.out.println(count);

	}

}
