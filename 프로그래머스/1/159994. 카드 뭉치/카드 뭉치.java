import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
	        String answer = "";
	        
	        int cd1Idx = 0, cd2Idx = 0;
	        int i=0;
	        for(String str : goal) {
	        	if (cd1Idx < cards1.length && str.equals(cards1[cd1Idx])) {
	                cd1Idx++;
	            } else if (cd2Idx < cards2.length && str.equals(cards2[cd2Idx])) {
	                cd2Idx++;
	            } else {
	                return "No"; 
	            }
	        }
	        
	        return "Yes"; 
	 }
}
