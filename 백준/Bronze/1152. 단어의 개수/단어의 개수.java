import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0; // 단어의 개수

		// #1. 문자열로 받아서 공백으로 split하는 방법
		String s = br.readLine();
		String[] input = s.split(" "); //split의 return타입이 String 배열이구나
		
//		System.out.println(Arrays.toString(input));
		for(int i=0; i<input.length; i++) {
			if(input[i].isBlank()) continue;
			cnt++;
		}
		
		System.out.println(cnt);
		
		

	}

}
