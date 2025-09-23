import java.util.*;

class Solution {
    	public int solution(int n, int w, int num) {
        int answer = 0;
        // int cnt = 1;
        // int[][] boxs = new int[n/w+1][w];
        // for(int i=0; i<n/w+1; i++){
        //     for(int j=0; j<w; j++){
        //         if(cnt)
        //     }
        // }
        // 스택을 w만큼 그룹으로 만들어서 쌓는 생각은?
        ArrayDeque<Integer>[] boxs = new ArrayDeque[w];
        for (int i = 0; i < w; i++) {
            boxs[i] = new ArrayDeque<>();
        }
        
        int col = 0; 
        int direct = 0;// 열과 방향(0일때 왼쪽, 1일때 오른쪽)을 저장
        int flag = 0; //꺼낼 스택의 열 위치 저장
        
        for(int i=1; i<=n; i++){
            boxs[col].push(i);
            if(i == num) flag = col;
            
            if(direct == 0) col++;
            else col--;
            
            //방향바꾸기
            if(col == w){
                col = w-1;
                direct = 1;
            }
            else if(col < 0){
                col = 0;
                direct = 0;
            }
            
        }
        
        while(!boxs[flag].isEmpty()){
            if(boxs[flag].pop() == num) break;
            answer++;
        }
        
        return answer+1; //꺼내는 상자까지 포함
    }
}