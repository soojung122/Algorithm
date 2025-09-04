import java.util.*;

public class Main {

	public static void main(String[] args)  {
		//13300번
	
		Scanner sc = new Scanner(System.in);
		
       int tot = sc.nextInt(); // 총 학생 수
        int N = sc.nextInt(); // 최대 인원
        int cnt = 0; // 
       
//        System.out.println(tot + " " + N);
        
        
        int[][] students = new int[7][2];
        for(int i=0; i<tot; i++) {
        	int sex = sc.nextInt();
        	int grade = sc.nextInt();
        	
        	students[grade][sex]++;
        }
        
        // 방의 개수 세기
        for(int i=1; i<7; i++) {
        	for(int j=0; j<2; j++) {
        		if(students[i][j] > 0 ) {
        			cnt += (students[i][j] / N) + ((students[i][j] % N == 0) ? 0 : 1);
        		}
        	}
        	
        }
        System.out.println(cnt);
        
        
	}
}