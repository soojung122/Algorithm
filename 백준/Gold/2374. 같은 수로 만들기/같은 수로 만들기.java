
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        int cur = Integer.parseInt(br.readLine());
        int max = cur;

        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            max = Math.max(max, next);
            if (cur <= next) {
                answer += (next - cur);
            }
            cur = next;
        }
        answer += (max - cur);
        System.out.println(answer);
        br.close();
    }
}






