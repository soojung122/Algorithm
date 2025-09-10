import java.util.*;

class Solution {
   public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int i=0; //가장 작은
        int j=people.length-1; //가장 큰
        
        while(i <= j) {
        	if(people[i] + people[j] <= limit)
        		i++;
        	j--; // j는 항상 탑승
        	answer++;
        }
        return answer;
    }
}