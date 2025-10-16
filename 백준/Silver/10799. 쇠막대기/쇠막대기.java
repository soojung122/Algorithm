import java.util.*;
import java.io.*;

/*
 * 쇠막대기 아래에서 위로 겹침 -> 레이저를 수직으로 발사하여 자름
 * 쇠대막기는 자신보다 긴 쇠막대기 위에만 놓을 수 있음.
 * 완전히 포함하되 끝점 겹치지 않도록
 * 레이저는 한 개 이상 존재
 * 레이저는 양 끝점과 겹치지 않음.
 * --
 * stack 
 * */
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split("");
		ArrayDeque<String> stack = new ArrayDeque<>();
		
		 int count = 0;

	        for (int i = 0; i < st.length; i++) {
	            String cur = st[i];

	            if (cur.equals("(")) {
	                stack.push(cur);
	            } else { // )
	                stack.pop(); // 일단 ( 제거

	                //이전 문자가 ( 라면
	                if (st[i - 1].equals("(")) {
	                    count += stack.size(); // 현재 열린 막대기 수만큼
	                } else {
	                    count++; // 막대기의 끝
	                }
	            }
	        }

	        System.out.println(count);

	}

}
