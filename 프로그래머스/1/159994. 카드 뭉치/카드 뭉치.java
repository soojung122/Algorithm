import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx1 = 0;
        int idx2 = 0;
        int idxG = 0;
        
        while( true ) {
            
            if( idxG == goal.length ) return "Yes"; // 이전단계에서 모든 goal 의 단어를 소화
            
            // 현재 따질 goal 의 단어
            String curr = goal[idxG];
            
            if( idx1 <= cards1.length - 1 && curr.equals(cards1[idx1])) {
                idxG++;
                idx1++;
            }else if( idx2 <= cards2.length - 1 && curr.equals(cards2[idx2])) {
                idxG++;
                idx2++;
            }else {
                return "No";
            }
        }
    }
}