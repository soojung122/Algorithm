import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
		// 2750번
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //입력 개수
			
			int[] input = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(input);
			
			for(int i=0; i<N; i++)
				System.out.println(input[i]);
			
		}
	}
}