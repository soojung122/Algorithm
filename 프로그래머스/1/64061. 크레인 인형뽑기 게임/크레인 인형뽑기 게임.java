import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int move : moves) {
        	int c = move - 1;
        	for(int r=0; r<board.length; r++) {
        		if(board[r][c] != 0) {
        			int find = board[r][c];
        			board[r][c] =0;
        			
        			if(!stack.isEmpty() && stack.peek() == find) {
        				stack.pop();
        				answer += 2;
        			}
        			else
        				stack.push(find);
        			break;
        		}
        	}
        	
        }
        
        
        
        return answer;
    }
}