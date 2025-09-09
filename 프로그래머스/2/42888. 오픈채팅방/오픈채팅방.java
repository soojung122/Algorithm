import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
        	String[] First = record[i].split(" ");
      

        	if(First[0].equals("Leave")) {
        		// hashMap.remove(First[1]);
//        		answer[i] = "out";
                continue;
        	}
        	else { //Enter + change
//        		answer[i] = "in";
        		hashMap.put(First[1], First[2]);
        	}
        }
        
        String[] answer = new String[record.length];
        int idx = 0; // 실제 메시지 위치
        for(int i=0; i<record.length; i++) {
        	String[] First = record[i].split(" ");
            if(First[0].equals("Enter")) {
            	answer[idx++] = hashMap.get(First[1]) + "님이 들어왔습니다.";
            }
            else if(First[0].equals("Leave")) {
            	answer[idx++] = hashMap.get(First[1]) + "님이 나갔습니다.";
            }
           
        }
        
        
        
        
        return Arrays.copyOf(answer, idx);
    }

}
