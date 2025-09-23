import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
    int answer = 0;

    int newM = m; //증설된 서버 처리량
    PriorityQueue<Server> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.endTime));

    for(int i=0; i<players.length; i++) {
        //증설하면 k시간동안 유지된 다는 것을 저장해야 함.뭐 i때까지 m이 더해진다거나
        while(!pq.isEmpty() && pq.peek().endTime <= i) {
            pq.poll();
            newM -= m;
        }

        while(players[i] >= newM) { // 인원수가 m의 세, 네배이상이면 계속 처리해줘야 함.
            answer++; //서버 증설됨.   
            newM += m; //원본유지한 채 m씩 증가해야함.
            //시간대를 알려줘야 해 -> 증가된 순간에 또 증설되면 해당 시간도 필요해 그니까 일반 int로는 안됨
            pq.offer(new Server(i+k));

        }


    }

    return answer;
      
    }
    
    static class Server{
		int endTime; //i로 비교하면 됨. 넣을 때에도 i+k하면 됨.
		//근데 서버가 한 두 개가 아니면 어떻게 하냐구. 여전히 문제 해결이 안됨.
		
		
		Server(int endTime){
			this.endTime = endTime;
		}
	}

}